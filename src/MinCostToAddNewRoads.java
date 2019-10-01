import java.util.Arrays;
import java.util.Comparator;

public class MinCostToAddNewRoads {
    static int[] parents;

    public static int minCostToConnect(int numTotalAvailableCities, int numTotalAvailableRoads, int[][] roadsAvailable,
                                               int numNewRoadsConstruct, int[][] costNewRoadsConstruct) {
        parents = new int[numTotalAvailableCities + 1];
        int connected = numTotalAvailableCities, minCost = 0;
        for (int i = 0; i <= numTotalAvailableCities; i++) {
            parents[i] = i;
        }
        for (int[] edge : roadsAvailable) {
            if (union(edge[0], edge[1])) {
                connected--;
            }
        }
        Arrays.sort(costNewRoadsConstruct, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                return arr1[2] - arr2[2];
            }
        });
        for (int[] newEdge : costNewRoadsConstruct) {
            if (union(newEdge[0], newEdge[1])) {
                minCost += newEdge[2];
                connected--;
            }
            if (connected == 1) {
                return minCost;
            }
        }
        return connected == 1 ? connected : -1;
    }

    private static boolean union(int x, int y) {
        int setX = find(x);
        int setY = find(y);
        if (setX != setY) {
            parents[setY] = setX;
            return true;
        }
        return false;
    }

    private static int find(int num) {
        if (parents[num] != num) {
            parents[num] = find(parents[num]);
        }
        return parents[num];
    }

    public static void main(String[] args) {
        int tc1 = minCostToConnect(6, 3, new int[][]{{1, 4}, {4, 5}, {2, 3}}, 4, new int[][]{{1, 2, 5}, {1, 3, 10}, {1, 6, 2}, {5, 6, 5}});
        if (tc1 == 7) {
            System.out.println("All Test Case Pass!");
        } else {
            System.out.println("There are test failures!");
        }
    }
}
