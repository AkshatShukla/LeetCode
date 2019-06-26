import java.util.*;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        Set<int[]> result = new HashSet<>();
        if (intervals.length == 0) {
            return new int[][]{};
        }
        if (intervals.length == 1) {
            return intervals;
        }
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int[] interval : intervals) {
            if (interval[0] <= end) {
                end = Math.max(end, interval[1]);
            } else {
                result.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        // Add last interval
        result.add(new int[]{start, end});
        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        int[][] input2 = new int[][]{{1, 4}, {4, 5}};
        int[][] input3 = new int[][]{};
        int[][] input4 = new int[][]{{1, 3}};
        int[][] input5 = new int[][]{{1, 4}, {2, 3}};
        System.out.println(Arrays.deepToString(merge(input)));
        System.out.println(Arrays.deepToString(merge(input2)));
        System.out.println(Arrays.deepToString(merge(input3)));
        System.out.println(Arrays.deepToString(merge(input4)));
        System.out.println(Arrays.deepToString(merge(input5)));
    }
}
