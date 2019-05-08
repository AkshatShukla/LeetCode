import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianFromDataStream {
    private Queue<Long> minHeap;
    private Queue<Long> maxHeap;

    /** initialize your data structure here. */
    public FindMedianFromDataStream() {
        minHeap = new PriorityQueue<>();
        maxHeap =  new PriorityQueue<>(Comparator.comparingLong(a -> -a));
    }

    public void addNum(int num) {
        /*
        Add num to max-heap lo. Since lo received a new element, we must do a balancing step for hi. So remove the largest element from lo and offer it to hi.
        The min-heap hi might end holding more elements than the max-heap lo, after the previous operation. We fix that by removing the smallest element from hi and offering it to lo.
         */
        maxHeap.offer((long) num);
        minHeap.offer(maxHeap.poll());
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }

    public static void main(String[] args) {
        FindMedianFromDataStream obj = new FindMedianFromDataStream();
        obj.addNum(1);
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
    }
}
