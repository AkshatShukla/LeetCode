import java.util.*;

public class SlidingWindowMedian {
    /*
    Almost the same idea of Find Median from Data Stream https://leetcode.com/problems/find-median-from-data-stream/

    Use two Heaps to store numbers. maxHeap for numbers smaller than current median, minHeap for numbers bigger than
    and equal to current median. A small trick I used is always make size of minHeap equal (when there are even numbers)
    or 1 element more (when there are odd numbers) than the size of maxHeap. Then it will become very easy to calculate
    current median.
    Keep adding number from the right side of the sliding window and remove number from left side of the sliding window.
    And keep adding current median to the result.
     */
    public static double[] medianSlidingWindow(int[] nums, int k) {
        List<Double> medians = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i <= nums.length; i++) {
            if (i >= k) {
                double median = getMedian(minHeap, maxHeap);
                medians.add(median);
                remove(nums[i - k], minHeap, maxHeap);
            }
            if (i < nums.length) {
                add(nums[i], minHeap, maxHeap);
            }
        }

        double[] ans = new double[medians.size()];
        for (int idx = 0; idx < ans.length; idx++) {
            ans[idx] = medians.get(idx);
        }
        return ans;
    }

    public static void add(int n, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (n < getMedian(minHeap, maxHeap)) {
            maxHeap.offer(n);
        } else {
            minHeap.offer(n);
        }
        if (maxHeap.size() > minHeap.size()) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public static void remove(int n, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (n < getMedian(minHeap, maxHeap)) {
            maxHeap.remove(n);
        } else {
            minHeap.remove(n);
        }
        if (maxHeap.size() > minHeap.size()) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public static double getMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (minHeap.isEmpty() && maxHeap.isEmpty()) {
            return 0.0;
        }
        if (minHeap.size() == maxHeap.size()) {
            // even length
            return ((double) maxHeap.peek() + (double) minHeap.peek()) / 2.0;
        } else {
            return (double) minHeap.peek();
        }
    }

    public static double[] medianSlidingWindowNaive(int[] nums, int k) {
        List<Double> medians = new ArrayList<>();

        int i = 0;
        int j = i + k;
        boolean even = k % 2 == 0;

        while (j <= nums.length) {
            int[] current = Arrays.copyOfRange(nums, i, j);
            Arrays.sort(current);
            double mid;
            if (!even) {
                mid = current[(j - i) / 2];
            } else {
                mid = (current[(j - i) / 2] + current[(j - i) / 2 - 1]) / 2.0;

            }
            medians.add(mid);
            i++;
            j++;
        }
        double[] ans = new double[medians.size()];
        for (int idx = 0; idx < ans.length; idx++) {
            ans[idx] = medians.get(idx);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(medianSlidingWindow(new int[]{1, 2}, 2)));
        System.out.println(Arrays.toString(medianSlidingWindowNaive(new int[]{1, 2}, 2)));
    }
}
