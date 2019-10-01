import java.util.*;

public class OptimalUtilization {
    public static List<int[]> optimize(int maxDistance, List<int[]> forwardRoutes, List<int[]> returnRoutes) {
        List<int[]> result = new ArrayList<>();
        forwardRoutes.sort(Comparator.comparingInt(i -> i[1]));
        returnRoutes.sort(Comparator.comparingInt(i -> i[1]));
        /*
        maxTravelDist = 10000
        forwardRouteList = [[1, 3000], [2, 5000], [3, 7000], [4, 10000]]
                                ^
        returnRouteList = [[1, 2000], [2, 3000], [3, 4000], [4, 5000]]
                                                               ^
         */

        int maxSum = Integer.MIN_VALUE;
        int i = 0;
        int j = returnRoutes.size() - 1;

        while (i < forwardRoutes.size() && j >= 0) {
            int sum = forwardRoutes.get(i)[1] + returnRoutes.get(j)[1];
            if (sum > maxDistance) {
                j--;
            } else {
                if (maxSum <= sum) {
                    if (maxSum < sum) {
                        maxSum = sum;
                        result.clear();
                    }
                    result.add(new int[]{forwardRoutes.get(i)[0], returnRoutes.get(j)[0]});
                    int index = j - 1;
                    while (index >= 0 && returnRoutes.get(index)[1] == returnRoutes.get(index + 1)[1]) {
                        result.add(new int[]{forwardRoutes.get(i)[0], returnRoutes.get(index)[0]});
                        index--;
                    }
                }
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<int[]> forwardRoutes = new ArrayList<>();
        forwardRoutes.add(new int[]{1, 3000});
        forwardRoutes.add(new int[]{2, 5000});
        forwardRoutes.add(new int[]{3, 7000});
        forwardRoutes.add(new int[]{4, 10000});
        List<int[]> returnRoutes = new ArrayList<>();
        returnRoutes.add(new int[]{1, 2000});
        returnRoutes.add(new int[]{2, 3000});
        returnRoutes.add(new int[]{3, 4000});
        returnRoutes.add(new int[]{4, 5000});
        List<int[]> optimalRoutes = optimize(10000, forwardRoutes, returnRoutes);
        for (int[] ints : optimalRoutes) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
