public class MinimumAbsoluteDifferenceInBST {
    public static int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int[] a = new int[]{-1, Integer.MAX_VALUE};
        int[] result = inorder(root, a);
        return result[1];
    }

    public static int[] inorder(TreeNode root, int[] a) {
        /*
        Since this is a BST, the inorder traversal of its nodes results in a sorted list of values.
        Thus, the minimum absolute difference must occur in any adjacently traversed nodes.
         */
        int res = a[1];
        if (root == null) {
            return a;
        }
        int[] left = inorder(root.left, a);
        if (left[0] != -1) {
            res = Math.min(left[1], root.val - left[0]);
        }
        a[0] = root.val;
        a[1] = res;
        return inorder(root.right, a);
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        one.right = three;
        three.left = two;
        System.out.println(getMinimumDifference(one));
    }
}
