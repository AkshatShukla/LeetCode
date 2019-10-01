public class ConvertSortedListToBST {
    private ListNode head;

    public TreeNode sortedListToBST(ListNode head) {
        // get size of LL
        if (head == null) {
            return null;
        }
        this.head = head;
        int size = getSize(head);

        return sortedListToBST(0, size - 1);
    }

    public int getSize(ListNode head) {
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    public TreeNode sortedListToBST(int low, int high) {
        if (low > high) {
            return null;
        }

        int mid = low + (high - low) / 2;
        TreeNode left = sortedListToBST(low, mid - 1);

        TreeNode root = new TreeNode(this.head.val);
        root.left = left;

        this.head = this.head.next;

        TreeNode right = sortedListToBST(mid + 1, high);
        root.right = right;

        return root;
    }

    public static void main(String[] args) {
        ConvertSortedListToBST obj = new ConvertSortedListToBST();

    }
}
