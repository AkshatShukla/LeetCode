public class PathSum {
    public static boolean hasPathSum(TreeNode root, int sum) {
        // The basic idea is to subtract the value of current node from sum until it reaches a leaf node and the
        // subtraction equals 0, then we know that we got a hit. Otherwise the subtraction at the end could not be 0.
        if(root == null) {
            return false;
        }

        if(root.left == null && root.right == null && sum - root.val == 0) {
            return true;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
