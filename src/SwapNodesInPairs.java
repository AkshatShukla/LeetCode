public class SwapNodesInPairs {
    public static ListNode swapPairs(ListNode head) {
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode dummy = result;
        while (head != null && head.next != null) {
            ListNode temp = head.next;
            result.next = temp;
            head.next = temp.next;
            temp.next = head;

            head = head.next;
            result = result.next.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        one.next = two;
        two.next = three;
        three.next = four;
        ListNode head = swapPairs(one);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
