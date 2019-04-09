public class MaxDepthBinaryTree {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        System.out.println(maxDepth(p));
    }

    private static int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        return 1+ Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
