public class MergeTwoSortedLists {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode resultList = new ListNode(0);
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode prev = resultList;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        if (l1 != null) {
            prev.next = l1;
        }
        if (l2 != null) {
            prev.next = l2;
        }
        return resultList.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode four2 = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        head.next = two;
        two.next = four;
        three.next = four2;
        four2.next = five;
        five.next = six;
        /*
         LinkedList 1: 1->2->4
         LinkedList 2: 3->4->5->6
         */
        System.out.println("first val:" + mergeTwoLists(head, three));
    }
}
