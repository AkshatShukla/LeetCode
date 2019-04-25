public class DiameterOfBinaryTree {
    private static int diameter = 0;

    public static int diameterOfBinaryTreeNaive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int LHeight = maxHeight(root.left);
        int RHeight = maxHeight(root.right);
        int LDiameter = diameterOfBinaryTreeNaive(root.left);
        int RDiameter = diameterOfBinaryTreeNaive(root.right);
        int diameter = Math.max(LHeight + RHeight + 1, Math.max(LDiameter, RDiameter) + 1);
        return diameter - 1;
    }

    private static int maxHeight(TreeNode root) {
        if(root == null)
            return 0;
        return 1 + Math.max(maxHeight(root.left), maxHeight(root.right));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        diameter = 1;
        depth(root);
        return diameter - 1;
    }

    public static int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int L = depth(node.left);
        int R = depth(node.right);
        diameter = Math.max(diameter, L+R+1);
        return Math.max(L, R) + 1;
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        System.out.println(diameterOfBinaryTree(one)); // 3
        System.out.println(diameterOfBinaryTreeNaive(one)); // 3
    }
}
