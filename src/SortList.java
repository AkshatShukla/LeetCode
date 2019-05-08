public class SortList {
    public static ListNode sortList(ListNode head) {
        // this is not using constant space.
        if (head == null || head.next == null) {
            return head;
        }

        //Step 1: split the list into halves
        ListNode prev = new ListNode(-1);
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        prev.next = null;

        //Step 2: sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        //Step 3: merge the two halves
        return merge(l1, l2);
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode tmp = result;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tmp.next = l1;
                l1 = l1.next;
            } else {
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }

        if (l1 != null) {
            tmp.next = l1;
        }
        if (l2 != null) {
            tmp.next = l2;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        four.next = two;
        two.next = one;
        one.next = three;
        ListNode sortedHead = sortList(four);
        while (sortedHead != null) {
            System.out.println(sortedHead.val);
            sortedHead = sortedHead.next;
        }
    }
}
