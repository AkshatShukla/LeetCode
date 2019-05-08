import java.util.*;

public class SecondMinimumNodeInBinaryTree {
    public static int findSecondMinimumValue(TreeNode root) {
        Set<Integer> res = new TreeSet<>();
        inorderTraversal(root, res);
        System.out.println(res);
        Iterator<Integer> iterator = res.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            count++;
            int result = iterator.next();
            if (count == 2) {
                return result;
            }
        }
        return -1;
    }

    public static void inorderTraversal(TreeNode root, Set<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        inorderTraversal(root.left, res);
        inorderTraversal(root.right, res);
    }

    public static void main(String[] args) {
        TreeNode two = new TreeNode(2);
        TreeNode two2 = new TreeNode(2);
        TreeNode five = new TreeNode(5);
        TreeNode five2 = new TreeNode(5);
        TreeNode seven = new TreeNode(7);
        two.left = two2;
        two.right = five;
        five.left = five2;
        five.right = seven;
        System.out.println(findSecondMinimumValue(two));
    }
}
