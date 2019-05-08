import java.util.*;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> ret = new ArrayList<>();
        int[] prev = null;
        for (int[] inter : intervals) {
            //if prev is null or curr.start > prev.end, add the interval
            if (prev == null || inter[0] > prev[1]) {
                ret.add(inter);
                prev = inter;
            } else if (inter[1] > prev[1]) {
                // curr.end > prev.end, modify the element already in list
                prev[1] = inter[1];
            }
        }
        return ret.toArray(new int[ret.size()][2]);
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] input2 = new int[][]{{0, 30}, {5, 10}, {15, 20}};
        System.out.println(Arrays.deepToString(merge(input)));
        System.out.println(Arrays.deepToString(merge(input2)));
    }
}
