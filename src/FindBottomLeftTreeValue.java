public class FindBottomLeftTreeValue {
    private static int maxDepth;
    private static int value;
    public static int findBottomLeftValue(TreeNode root) {
        value = root.val;
        maxDepth = 1;
        traverseLeft(root, 1);
        return value;
    }

    private static void traverseLeft(TreeNode root, int depthSoFar) {
        if (root == null)
            return;
        if (depthSoFar > maxDepth) {
            maxDepth = depthSoFar;
            value = root.val;
        }
        traverseLeft(root.left, depthSoFar + 1);
        traverseLeft(root.right, depthSoFar + 1);
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        one.left = two;
        one.right = three;
        two.left = four;
        three.left = five;
        three.right = six;
        five.left = seven;
        System.out.println(findBottomLeftValue(one));
    }
}
