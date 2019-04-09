import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        head.next = two;
        two.next = head;
        System.out.println(hasCycle(head));
    }

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
}
