import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreePreorderAndInorderTraversal {
    int pre;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return tree(0, inorder.length - 1, preorder, map);
    }

    public TreeNode tree(int start, int end, int[] preorder, Map<Integer, Integer> map) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pre]);
        int r = pre;
        pre++;
        root.left = tree(start, map.get(preorder[r]) - 1, preorder, map);
        root.right = tree(map.get(preorder[r]) + 1, end, preorder, map);
        return root;
    }
}
