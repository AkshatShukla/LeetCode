public class BinaryTreeMaximumPathSum {
    public static int maxPathSum(TreeNode root) {
        int[] res = new int[]{Integer.MIN_VALUE};
        if (root == null)
            return 0;
        helper(root, res);
        return res[0];
    }

    public static int helper(TreeNode root, int[] res) {
        if (root == null)
            return 0;
        int curr = root.val;
        int leftSum = helper(root.left, res);
        int rightSum = helper(root.right, res);
        int path = Math.max(curr, curr + Math.max(leftSum, rightSum));
        res[0] = Math.max(res[0], path);
        res[0] = Math.max(res[0], curr + leftSum + rightSum);
        return path;
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        one.left = two;
        one.right = three;
        System.out.println(maxPathSum(one));

        TreeNode ten = new TreeNode(-10);
        TreeNode nine = new TreeNode(9);
        TreeNode twenty = new TreeNode(20);
        TreeNode fifteen = new TreeNode(15);
        TreeNode seven = new TreeNode(7);
        ten.left = nine;
        ten.right = twenty;
        twenty.left = fifteen;
        twenty.right = seven;

        System.out.println(maxPathSum(ten));
    }
}
