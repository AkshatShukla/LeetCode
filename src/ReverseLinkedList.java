public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        head.next = two;
        two.next = three;
        System.out.println(reverseList(head));
    }

    /*
    While you are traversing the list, change the current node's next pointer to point to its previous element.
    Since a node does not have reference to its previous node, you must store its previous element beforehand.
    You also need another pointer to store the next node before changing the reference. Do not forget to return
    the new head reference at the end!
     */
    private static ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
