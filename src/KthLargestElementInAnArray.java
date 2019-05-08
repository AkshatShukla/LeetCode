import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAnArray {
    public static int findKthLargest(int[] nums, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        for (int i = 0; i<nums.length; i++) {
            maxHeap.offer(nums[i]);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return maxHeap.peek() != null ? maxHeap.poll() : -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }
}
