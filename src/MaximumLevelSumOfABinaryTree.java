import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumOfABinaryTree {
    public static int maxLevelSum(TreeNode root) {
        // do BFS and update the max at each level
        int maxSum = Integer.MIN_VALUE;
        int ans = 0;
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int levelNodes = queue.size();
            int levelSum = 0;
            for (int i = 0; i < levelNodes; i++) {
                TreeNode currNode = queue.poll();
                levelSum += currNode.val;
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
            level++;
            if (levelSum > maxSum) {
                maxSum = levelSum;
                ans = level;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode seven = new TreeNode(7);
        TreeNode zero = new TreeNode(0);
        TreeNode seven1 = new TreeNode(7);
        TreeNode eight = new TreeNode(-8);
        one.left = seven;
        one.right = zero;
        seven.left = seven1;
        seven.right = eight;
        System.out.println(maxLevelSum(one));
        /*
        Level 1 sum = 1.
        Level 2 sum = 7 + 0 = 7.
        Level 3 sum = 7 + -8 = -1.
        So we return the level with the maximum sum which is level 2.
         */
    }
}
