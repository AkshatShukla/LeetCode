public class UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        boolean leftAns = (root.left == null) || (root.val == root.left.val && isUnivalTree(root.left));
        boolean rightAns = (root.right == null) || (root.val == root.right.val && isUnivalTree(root.right));
        return leftAns && rightAns;
    }
}
