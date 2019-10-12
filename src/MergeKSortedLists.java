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

    public static ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        int interval = 1;
        while (interval < lists.length) {
            for (int i = 0; i + interval < lists.length; i = i + interval * 2) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        if (head1 == null)
            return head2;

        if (head2 == null)
            return head1;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                curr.next = head1;
                curr = curr.next;
                head1 = head1.next;
            } else {
                curr.next = head2;
                curr = curr.next;
                head2 = head2.next;
            }
        }

        if (head1 != null) {
            curr.next = head1;
            curr = curr.next;
            head1 = head1.next;
        }

        if (head2 != null) {
            curr.next = head2;
            curr = curr.next;
            head2 = head2.next;
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
