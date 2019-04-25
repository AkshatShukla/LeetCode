public class RemoveLinkedListElements {
    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = head;
        ListNode prev = dummy;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        ListNode six2 = new ListNode(6);
        ListNode oneNew = new ListNode(1);
        ListNode one2New = new ListNode(1);
        oneNew.next = one2New;
        head.next = two;
        two.next = six;
        six.next = three;
        three.next = four;
        four.next = five;
        five.next = six2;
        ListNode res = removeElements(head, 6);
        ListNode res2 = removeElements(oneNew, 1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
        System.out.println(res2);
    }
}
