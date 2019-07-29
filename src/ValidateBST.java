public class ValidateBST {
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && maxVal(root.left) >= root.val) {
            return false;
        }
        if (root.right != null && minVal(root.right) <= root.val) {
            return false;
        }

        boolean leftSubTree = isValidBST(root.left);
        boolean rightSubTree = isValidBST(root.right);

        return leftSubTree && rightSubTree;
    }

    public static int minVal(TreeNode root){
        if (root == null)
            return -1;
        while (root.left != null)
            root = root.left;
        return root.val;
    }

    public static int maxVal(TreeNode root){
        if (root == null)
            return Integer.MAX_VALUE;
        while (root.right != null)
            root = root.right;
        return root.val;
    }

    public static void main(String[] args) {
        TreeNode five = new TreeNode(5);
        TreeNode one = new TreeNode(1);
        TreeNode four = new TreeNode(4);
        TreeNode three = new TreeNode(3);
        TreeNode six = new TreeNode(6);
        five.left = one;
        five.right = four;
        four.left = three;
        four.right = six;
        System.out.println(isValidBST(five)); // false
    }
}
