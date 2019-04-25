public class RemoveNthNodeFromEndOfList {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = new ListNode(-1);
        ListNode walker = head;
        ListNode runner = head;

        for (int i=0; i<n; i++) {
            runner = runner.next;
        }

        while (runner != null) {
            prev = walker;
            walker = walker.next;
            runner = runner.next;
        }
        if (prev.next != null) {
            prev.next = prev.next.next;
            return head;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        System.out.println(removeNthFromEnd(one, 1).val);
    }
}
