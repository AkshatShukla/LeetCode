import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public static List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        rec(root, res);
        return res;
    }

    public static void rec(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                rec(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                rec(root.right, res);
            }
        }
    }

    public static List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        one.right = two;
        two.left = three;
        for (int n:inorderTraversalRecursive(one)) {
            System.out.println(n);
        }
        for (int n:inorderTraversalIterative(one)) {
            System.out.println(n);
        }
    }
}
