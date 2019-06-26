import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (ListNode head : lists) {
            while (head != null) {
                minHeap.add(head.val);
                head = head.next;
            }
        }
        System.out.println(minHeap);
        ListNode dummy = new ListNode(-1); // placeholder
        ListNode head = dummy;
        while (!minHeap.isEmpty()) {
            head.next = new ListNode(minHeap.poll());
            head = head.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode one1 = new ListNode(1);
        ListNode four = new ListNode(4);
        ListNode four1 = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);

        one.next = four;
        four.next = five;
        one1.next = three;
        three.next = four1;
        two.next = six;

        ListNode[] input = new ListNode[]{one, one1, two};
        ListNode head = mergeKLists(input);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
