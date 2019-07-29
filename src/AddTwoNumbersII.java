import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class AddTwoNumbersII {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        ListNode head1 = l1;
        ListNode head2 = l2;
        int carry = 0;

        head1 = reverse(head1);
        head2 = reverse(head2);

        while (head1 != null || head2 != null) {
            int x = (head1 != null) ? head1.val : 0;
            int y = (head2 != null) ? head2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (head1 != null) head1 = head1.next;
            if (head2 != null) head2 = head2.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        ListNode newCurr = reverse(dummy.next);

        return newCurr;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    // Without reversing original input
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        // Use stacks
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        ListNode head1 = l1;
        ListNode head2 = l2;
        int carry = 0;

        Deque<Integer> s1 = new LinkedList<>();
        Deque<Integer> s2 = new LinkedList<>();

        while (head1 != null) {
            s1.addFirst(head1.val);
            head1 = head1.next;
        }

        while (head2 != null) {
            s2.addFirst(head2.val);
            head2 = head2.next;
        }

        while (!s1.isEmpty() || !s2.isEmpty()) {
            int x = (!s1.isEmpty()) ? s1.removeFirst() : 0;
            int y = (!s2.isEmpty()) ? s2.removeFirst() : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return reverse(dummy.next);
    }

    public static void main(String[] args) {
        ListNode seven = new ListNode(7);
        ListNode two = new ListNode(2);
        ListNode four = new ListNode(4);
        ListNode three = new ListNode(3);
        seven.next = two;
        two.next = four;
        four.next = three;

        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        ListNode four1 = new ListNode(4);
        five.next = six;
        six.next = four1;

        ListNode head = addTwoNumbers2(seven, five);

        while (head != null) {
            System.out.print(head.val + "->");
            if (head.next == null) {
                System.out.print("null");
            }
            head = head.next;
        }
    }
}
