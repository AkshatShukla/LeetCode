public class BinaryTreeTilt {
    public static int findTilt(TreeNode root) {
        int[] totalTilt = new int[]{0};
        calcTilt(root, totalTilt);
        return totalTilt[0];
    }

    public static int calcTilt(TreeNode root, int[] totalTilt) {
        if (root == null)
            return 0;
        int l = calcTilt(root.left, totalTilt);
        int r = calcTilt(root.right, totalTilt);
        totalTilt[0] += Math.abs(l - r);
        return l + r + root.val;
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        one.left = two;
        one.right = three;
        System.out.println(findTilt(one));
        /*
        The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values
        and the sum of all right subtree node values. Null node has tilt 0.
        Tilt of node 2 : 0
        Tilt of node 3 : 0
        Tilt of node 1 : |2-3| = 1
        Tilt of binary tree : 0 + 0 + 1 = 1
         */
    }
}
