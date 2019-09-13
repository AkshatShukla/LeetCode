public class MaximumAverageSubtree {
    private double max = Double.MIN_VALUE;
    public double maximumAverageSubtree(TreeNode root) {
        helper(root);
        return max;
    }
    private int[] helper(TreeNode node) {
        if(node == null) {
            return new int[]{0, 0};
        }

        int[] l = helper(node.left);
        int[] r = helper(node.right);
        int[] countSum = new int[2];
        countSum[0] = l[0] + r[0] + 1;
        countSum[1] = l[1] + r[1] + node.val;
        max = Math.max(max, (double)countSum[1] / (double)countSum[0]);
        return countSum;
    }
}
