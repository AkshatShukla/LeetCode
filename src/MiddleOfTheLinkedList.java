public class MiddleOfTheLinkedList {
    public static ListNode middleNodeNaive(ListNode head) {
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        int countSoFar = 0;
        ListNode newCurr = head;
        while (newCurr != null) {
            countSoFar++;
            if (countSoFar == count/2) {
                return newCurr.next;
            }
            newCurr = newCurr.next;
        }
        return head;
    }

    public static ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
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
        System.out.println(middleNodeNaive(one).val); // 4
        System.out.println(middleNode(one).val); // 4
    }
}
