import java.util.*;

public class SubdomainVisitCount {
    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();

        for(String domain : cpdomains)
        {
            int index = domain.indexOf(' ');
            int val = Integer.parseInt(domain.substring(0, index));
            String tempStr = domain.substring(index + 1);
            int ittr = tempStr.split("\\.").length;
            for(int i = 0; i < ittr; i++) {
                map.put(tempStr, map.getOrDefault(tempStr, 0) + val);
                tempStr = tempStr.substring(tempStr.indexOf(".") + 1);
            }
        }

        for (String domain:map.keySet()) {
            result.add(map.get(domain).toString() + " " + domain);
        }

        return result;
    }

    public static void main(String[] args) {
        String[] input = new String[]{"9001 discuss.leetcode.com"};
        System.out.println(subdomainVisits(input));
    }
}
