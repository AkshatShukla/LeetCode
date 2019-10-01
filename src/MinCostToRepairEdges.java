import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class MinCostToRepairEdges {
    static int[] parents;

    public int minCostToConnect(int n, int[][] edges, int[][] edgesToRepair) {
        int connect = n, totalCost = 0;
        parents = new int[n + 1];
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for (int[] edge : edgesToRepair) {
            StringBuilder sb = new StringBuilder();
            sb.append(edge[0]).append("#").append(edge[1]);
            set.add(sb.toString());
        }
        for (int[] edge : edges) {
            StringBuilder sb = new StringBuilder();
            sb.append(edge[0]).append("#").append(edge[1]);
            if (!set.contains(sb.toString())) {
                union(edge[0], edge[1]);
                connect--;
            }
        }
        Arrays.sort(edgesToRepair, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                return arr1[2] - arr2[2];
            }
        });
        for (int[] edge : edgesToRepair) {
            if (union(edge[0], edge[1])) {
                totalCost += edge[2];
                connect--;
            }
            if (connect == 1) {
                return totalCost;
            }
        }
        return connect == 1 ? totalCost : -1;
    }

    public static boolean union(int x, int y) {
        int setX = find(x);
        int setY = find(y);
        if (setX != setY) {
            parents[setY] = setX;
            return true;
        }
        return false;
    }

    public static int find(int num) {
        if (parents[num] != num) {
            parents[num] = find(parents[num]);
        }
        return parents[num];
    }
}
