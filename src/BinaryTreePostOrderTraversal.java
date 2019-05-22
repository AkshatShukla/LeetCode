import java.util.*;

public class BinaryTreePostOrderTraversal {
    public static List<Integer> postorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversalRecursive(root, result);
        return result;
    }

    public static void postorderTraversalRecursive(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postorderTraversalRecursive(root.left, result);
        postorderTraversalRecursive(root.right, result);
        result.add(root.val);
    }

    public static List<Integer> postorderTraversalIterative(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>(); // use linkedlist to add first
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                result.addFirst(p.val);  // Reverse the process of preorder
                p = p.right;        // Reverse the process of preorder
            } else {
                TreeNode node = stack.pop();
                p = node.left;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        one.right = two;
        two.left = three;
        for (int n:postorderTraversalRecursive(one)) {
            System.out.println(n);
        }
        for (int n:postorderTraversalIterative(one)) {
            System.out.println(n);
        }
    }
}
