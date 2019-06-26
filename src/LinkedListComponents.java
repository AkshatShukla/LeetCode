import java.util.*;

public class LinkedListComponents {
    public static int numComponents(ListNode head, int[] G) {
        Set<Integer> Gset = new HashSet<>();
        for (int i : G) {
            Gset.add(i);
        }

        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            if (Gset.contains(cur.val) && (cur.next == null || !Gset.contains(cur.next.val)))
                count++;
            cur = cur.next;
        }

        return count;
    }

    public static void main(String[] args) {
        ListNode zero = new ListNode(0);
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        zero.next = one;
        one.next = two;
        two.next = three;
        System.out.println(numComponents(zero, new int[]{0, 1, 3}));
        three.next = new ListNode(4);
        System.out.println(numComponents(zero, new int[]{0, 3, 1, 4}));
    }
}
