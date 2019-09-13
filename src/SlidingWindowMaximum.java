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
        List<Integer> maxValues = new ArrayList<>();
        // scan the elements 1 at a time and keep filling minHeap
        Deque<Integer> deque = new LinkedList<>(); // stores indices

        for (int i = 0; i < nums.length; i++) {
            // remove indexes of elements out of sliding window
            if (!deque.isEmpty() && deque.peekFirst() == i - k)
                deque.removeFirst();

            // remove from deq indexes of all elements
            // which are smaller than current element nums[i]
            // maintain a descending order of deque(invariant)
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()])
                deque.removeLast();

            deque.addLast(i);

            if (i >= k - 1) {
                maxValues.add(nums[deque.peekFirst()]);
            }
        }

        int[] res = new int[maxValues.size()];
        int idx = 0;
        for (int i : maxValues) {
            res[idx++] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(maxSlidingWindow(input, 3)));

    }
}
