public class MinimumDepthOfBinaryTree {
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int L = Integer.MAX_VALUE, R = Integer.MAX_VALUE;
        if (root.left != null) L = minDepth(root.left);
        if (root.right != null) R = minDepth(root.right);
        return Math.min(L, R) + 1;
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        p.right = three;
        three.left = four;
        System.out.println(minDepth(p)); // 2
    }
}
