import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> list = new ArrayList<>();
        if (root == null)
            return list;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i<levelNum; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                tempList.add(queue.poll().val);
            }
            list.add(tempList);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode three = new TreeNode(3);
        TreeNode nine = new TreeNode(9);
        TreeNode twenty = new TreeNode(20);
        TreeNode fifteen = new TreeNode(15);
        TreeNode seven = new TreeNode(7);
        three.left = nine;
        three.right = twenty;
        twenty.left = fifteen;
        twenty.right = seven;
        System.out.println(levelOrder(three));
    }
}
