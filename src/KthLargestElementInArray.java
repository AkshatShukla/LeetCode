import java.util.PriorityQueue;

public class KthLargestElementInArray {
    PriorityQueue<Integer> minHeap;
    private int capacity;

    public KthLargestElementInArray(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        capacity = k;

        for (int i : nums) {
            minHeap.offer(i);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        minHeap.offer(val);
        while (minHeap.size() > capacity) {
            minHeap.poll();
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] ints = new int[]{4, 5, 8, 2};
        KthLargestElementInArray kthLargest = new KthLargestElementInArray(k, ints);
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}
