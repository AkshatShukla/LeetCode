import java.util.*;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindowNaive(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.comparingInt(a -> -a));
        int i = 0;
        int j = k - 1;
        int s = 0;
        while (i <= nums.length - k && j < nums.length) {
            for (int n = i; n <= j + 1; n++) {
                if (maxHeap.size() < k) {
                    maxHeap.offer(nums[n]);
                } else if (maxHeap.size() == k) {
                    result[s] = maxHeap.peek();
                    s++;
                    maxHeap.clear();
                }
            }
            i++;
            j++;
        }
        return result;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        int max_idx = 0;
        for (int i = 0; i < k; i++) {
            cleanDeque(deque, i, k, nums);
            deque.addLast(i);
            // compute max in nums[:k]
            if (nums[i] > nums[max_idx])
                max_idx = i;
        }
        result[0] = nums[max_idx];

        // build output
        for (int i = k; i < nums.length; i++) {
            cleanDeque(deque, i, k, nums);
            deque.addLast(i);
            result[i - k + 1] = nums[deque.peekFirst()];
        }
        return result;
    }

    private static void cleanDeque(Deque<Integer> deque, int i, int k, int[] nums) {
        // remove indexes of elements not from sliding window
        if (!deque.isEmpty() && deque.peekFirst() == i - k)
            deque.removeFirst();

        // remove from deq indexes of all elements
        // which are smaller than current element nums[i]
        while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()])
            deque.removeLast();
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(maxSlidingWindow(input, 3)));

    }
}
