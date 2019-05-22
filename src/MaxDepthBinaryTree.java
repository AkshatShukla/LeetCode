public class MaxDepthBinaryTree {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        System.out.println(maxDepthBottomUpRecursion(p));
        System.out.println(maxDepthTopDownRecursion(p));
    }

    private static int maxDepthBottomUpRecursion(TreeNode root) {
        if(root == null)
            return 0;
        int left_ans = maxDepthBottomUpRecursion(root.left);
        int right_ans = maxDepthBottomUpRecursion(root.right);
        return Math.max(left_ans, right_ans) + 1;
    }

    private static int depthSoFar = 1;
    private static int maxDepthTopDownRecursion(TreeNode root) {
        int maxDepth = 0;
        maxDepthTopDownRecursion(root, maxDepth);
        return depthSoFar;
    }

    private static void maxDepthTopDownRecursion(TreeNode root, int maxDepth) {
        if (root == null) {
            return;
        }
        if (root.left == null || root.right == null) {
            depthSoFar++;
            maxDepth = Math.max(maxDepth, depthSoFar);
        }
        maxDepthTopDownRecursion(root.left, maxDepth);
        maxDepthTopDownRecursion(root.right, maxDepth);
    }
}
