public class LowestCommonAncestorOfBinarySearchTree {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q); // traverse left subtree
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q); // traverse right subtree
        } else {
            return root; // current node is the lowest ancestor for p and q as there is a split
        }
    }
}
