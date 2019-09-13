import java.util.*;

public class ServerManager {

    public Map<String, List<Integer>> serverAppMap; // key as server and value as list of numeric entries
    private ServerManager() {
        serverAppMap = new HashMap<>();
    }
    private String allocate(String server) {
        List<Integer> allocatedServers = new ArrayList<>();
        int lowestAllocatableServer = 1;
        if (!serverAppMap.containsKey(server)) {
            allocatedServers.add(lowestAllocatableServer);
        } else {
            // find the lowest allocatable server to the give key
            // 1, 2, 3, 4, 6... => 5, find the first missing positive in the allocated server list
            allocatedServers = serverAppMap.get(server);
            lowestAllocatableServer = findMissingServer(allocatedServers);
            allocatedServers.add(lowestAllocatableServer);
        }
        Collections.sort(allocatedServers);
        serverAppMap.put(server, allocatedServers);
        return server + lowestAllocatableServer;
    }

    private int findMissingServer(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        for (int i = 0; i < list.size(); i++) {
            if (!set.contains(i + 1)) {
                return i + 1;
            }
        }
        return list.size() + 1;
    }

    private void deallocate(String server) {
        // need to split server to get number
        String[] components = parseServerName(server);
        if (serverAppMap.containsKey(components[0])) {
            List<Integer> allocatedServers = serverAppMap.get(components[0]);
            // apply binary search on allocated servers
            if (!components[1].isEmpty()) {
                int serverToRemove = binarySearch(allocatedServers, Integer.parseInt(components[1]));
                if (serverToRemove != -1)
                    allocatedServers.remove(serverToRemove);
                if (allocatedServers.isEmpty()) {
                    serverAppMap.remove(components[0]);
                } else {
                    Collections.sort(allocatedServers);
                    serverAppMap.put(components[0], allocatedServers);
                }
            }
        }
    }

    private String[] parseServerName(String server) {
        String[] comps = new String[2];
        StringBuilder serverName = new StringBuilder();
        StringBuilder serverNumber = new StringBuilder();
        for (char c : server.toCharArray()) {
            if (Character.isLetter(c)) {
                serverName.append(c);
            } else {
                serverNumber.append(c);
            }
        }
        comps[0] = serverName.toString();
        comps[1] = serverNumber.toString();
        return comps;
    }

    private int binarySearch(List<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (list.get(mid) == target) {
                return mid;
            }
            if (list.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        ServerManager serverManager = new ServerManager();
        System.out.println(serverManager.allocate("apibox"));
        System.out.println(serverManager.allocate("apibox"));
        System.out.println(serverManager.allocate("apibox"));
        serverManager.deallocate("apibox2");
        System.out.println(serverManager.allocate("apibox"));
        serverManager.deallocate("apibox3");
        System.out.println(serverManager.serverAppMap);
        System.out.println(serverManager.allocate("apibox"));
        System.out.println(serverManager.serverAppMap);
        System.out.println(serverManager.allocate("apibox"));
    }
}
