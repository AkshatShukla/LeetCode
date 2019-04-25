import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        head.next = two;
        two.next = head;
        System.out.println(hasCycle(head));
        System.out.println(hasCycleFast(head));
    }

    // O(n) Space Complexity
    private static boolean hasCycle(ListNode head) {
        Set<ListNode> seenNodes = new HashSet<>();
        while (head != null) {
            if (seenNodes.contains(head))
                return true;
            else
                seenNodes.add(head);
            head = head.next;
        }
        return false;
    }

    // O(1) Space Complexity
    // if the Linked List has a cycle slow and fast will meet at some
    // point.
    private static boolean hasCycleFast(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }

        return false;
    }
}
