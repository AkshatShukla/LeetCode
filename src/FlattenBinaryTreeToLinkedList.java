import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTreeToLinkedList {
    public static void flatten1(TreeNode root) {
        if (root == null)
            return;
        List<Integer> inorder = new ArrayList<>();
        inorderTraverse(root, inorder);
        inorder.remove(0);
        for (int val : inorder) {
            root.left = null;
            root.right = new TreeNode(val);
            root = root.right;
        }

    }

    public static void inorderTraverse(TreeNode root, List<Integer> inorder) {
        if (root == null)
            return;
        inorder.add(root.val);
        inorderTraverse(root.left, inorder);
        inorderTraverse(root.right, inorder);
    }

    public static void flatten2(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                TreeNode originalRight = current.right;
                TreeNode rightmostOnLeft = current.left;
                while (rightmostOnLeft.right != null) {
                    rightmostOnLeft = rightmostOnLeft.right;
                }
                rightmostOnLeft.right = originalRight;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }
}
