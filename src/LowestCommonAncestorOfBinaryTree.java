public class LowestCommonAncestorOfBinaryTree {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode leftAns = lowestCommonAncestor(root.left, p, q);
        TreeNode rightAns = lowestCommonAncestor(root.right, p, q);
        if (leftAns != null && rightAns != null) {
            return root;
        } else {
            return leftAns != null ? leftAns : rightAns;
        }
    }
}
