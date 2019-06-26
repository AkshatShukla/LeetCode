
public class SumRootToLeafNumbers {
    public static int sumNumbers(TreeNode root) {
        return traverse(root, 0);
    }

    private static int traverse(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left == null) {
            return sum * 10 + root.val;
        }
        return traverse(root.left, sum * 10 + root.val) + traverse(root.right, sum * 10 + root.val);
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        one.left = two;
        one.right = three;

        System.out.println(sumNumbers(one));
    }
}
