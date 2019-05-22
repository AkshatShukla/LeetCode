import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public static int[][] kClosest(int[][] points, int K) {
        /*
        Put the points into a PriorityQueue, and the order is by their distance to origin descendingly;
        Whenever the size reach K + 1, poll the farthest point out.
        O(NlogK)
         */
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(Comparator.comparing(a -> -a[0] * a[0] - a[1] * a[1]));

        for (int[] p : points) {
            maxHeap.offer(p);
            if (maxHeap.size() > K) { maxHeap.poll(); } // poll out the farthest among the K + 1 points.
        }
        int[][] ans = new int[K][2];
        while (K-- > 0) {
            ans[K] = maxHeap.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(kClosest(new int[][]{{1, 3}, {-2, 2}}, 1))); // [[-2, 2]]

    }
}
