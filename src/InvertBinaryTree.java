public class InvertBinaryTree {
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
        TreeNode four = new TreeNode(4);
        TreeNode two = new TreeNode(2);
        TreeNode seven = new TreeNode(7);
        TreeNode one = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        TreeNode six = new TreeNode(6);
        TreeNode nine = new TreeNode(9);
        four.left = two;
        four.right = seven;
        two.left = one;
        two.right = three;
        seven.left = six;
        seven.right = nine;

        System.out.println(invertTree(four));
    }
}
