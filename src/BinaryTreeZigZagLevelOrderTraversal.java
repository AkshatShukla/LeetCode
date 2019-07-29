import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigZagLevelOrderTraversal {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return ans;
        }

        queue.offer(root);
        String direction = "left";

        while (!queue.isEmpty()) {
            int level = queue.size();
            LinkedList<Integer> levelNodes = new LinkedList<>();
            for (int i = 0; i < level; i++) {
                TreeNode curr = queue.peek();
                if (direction.equals("right")) {
                    levelNodes.addFirst(queue.poll().val);
                } else {
                    levelNodes.addLast(queue.poll().val);
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            ans.add(levelNodes);
            direction = direction.equals("right") ? "left" : "right";
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        one.left = two;
        one.right = three;
        two.left = four;
        three.right = five;
        System.out.println(zigzagLevelOrder(one));
    }
}
