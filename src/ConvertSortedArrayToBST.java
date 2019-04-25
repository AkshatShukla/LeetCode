import java.util.Arrays;

public class ConvertSortedArrayToBST {
    public static TreeNode sortedArrayToBST(int[] nums) {
        return rec(nums, 0, nums.length - 1);
    }

    public static TreeNode rec(int[] num, int low, int high) {
        // at leaf
        if (low > high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = rec(num, low, mid - 1);
        root.right = rec(num, mid + 1, high);
        return root;
    }

    public static void printBST(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        printBST(root.left);
        printBST(root.right);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};
        TreeNode root = sortedArrayToBST(nums);
        printBST(root);
    }
}
