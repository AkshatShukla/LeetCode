public class LinkedListCycle2 {
    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode walker = head;
        ListNode runner = head;

        while (runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner) {
                ListNode walker2 = head;
                while (walker2 != walker) {
                    walker2 = walker2.next;
                    walker = walker.next;
                }
                return walker;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(-4);
        head.next = two;
        two.next = three;
        three.next = four;
        four.next = two;
        System.out.println("tail connects to node value "+detectCycle(head).val);

    }
}
