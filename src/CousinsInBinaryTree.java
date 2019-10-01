import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CousinsInBinaryTree {
    public static boolean isCousins(TreeNode root, int x, int y) {
        if (root == null)
            return false;

        Queue<Pair<TreeNode, TreeNode>> queue = new LinkedList<>();
        queue.offer(new Pair<>(new TreeNode(-1), root));

        while (!queue.isEmpty()) {
            int level = queue.size();
            Map<Integer, Integer> parentNodeMap = new HashMap<>();
            for (int i = 0; i < level; i++) {
                Pair<TreeNode, TreeNode> node = queue.poll();
                TreeNode parent = node.getKey();
                TreeNode curr = node.getValue();
                parentNodeMap.put(curr.val, parent.val);
                if (curr.left != null) {
                    queue.offer(new Pair<>(curr, curr.left));
                }
                if (curr.right != null) {
                    queue.offer(new Pair<>(curr, curr.right));
                }
            }
            if (parentNodeMap.containsKey(x) && parentNodeMap.containsKey(y)) {
                return !parentNodeMap.get(x).equals(parentNodeMap.get(y));
            }
        }

        return false;
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);

    }
}
