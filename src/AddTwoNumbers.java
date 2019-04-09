/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class ListNode {
    int val;
    ListNode next = null;
    ListNode(int x) {
        val = x;
    }
}
class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pointer1 = l1;
        ListNode pointer2 = l2;
        ListNode result = new ListNode(0);
        ListNode resultPointer = result;

        int sum, digit,carry = 0;

        while (pointer1!=null || pointer2 !=null || carry!=0) {
            sum = 0;
            resultPointer.next = new ListNode(0);
            resultPointer = resultPointer.next;

            if (pointer1 != null) {
                sum += pointer1.val;
                pointer1 = pointer1.next;
            }

            if (pointer2 !=null) {
                sum += pointer2.val;
                pointer2 = pointer2.next;
            }

            sum += carry;

            digit = sum % 10;
            carry = sum / 10;

            resultPointer.val = digit;
        }

        return result.next;
    }
}