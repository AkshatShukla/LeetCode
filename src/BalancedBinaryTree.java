public class BalancedBinaryTree {
    public static boolean isBalanced(TreeNode root) {
        return dfsDepth(root) != -1;
    }

    public static int dfsDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int L = dfsDepth(node.left);
        if (L == -1) {
            return -1;
        }
        int R = dfsDepth(node.right);
        if (R == -1) {
            return -1;
        }
        if (Math.abs(L - R) > 1) {
            return -1;
        }
        return 1 + Math.max(L, R);
    }

    public static void main(String[] args) {
        TreeNode three = new TreeNode(3);
        TreeNode nine = new TreeNode(9);
        TreeNode twenty = new TreeNode(20);
        TreeNode fifteen = new TreeNode(15);
        TreeNode seven = new TreeNode(7);
        three.left = nine;
        three.right = twenty;
        twenty.left = fifteen;
        twenty.right = seven;

        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode two2 = new TreeNode(2);
        TreeNode three2 = new TreeNode(3);
        TreeNode three3 = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode four2 = new TreeNode(4);
        one.left = two;
        one.right = two2;
        two.left = three2;
        two.right = three3;
        three2.left = four;
        three2.left = four2;

        TreeNode newTwo = new TreeNode(2);
        TreeNode newOne = new TreeNode(1);
        TreeNode newThree = new TreeNode(3);
        newTwo.left = newOne;
        newTwo.right = newThree;

        TreeNode zero = new TreeNode(0);
        System.out.println(isBalanced(three)); // true
        System.out.println(isBalanced(one)); // false
        System.out.println(isBalanced(newTwo)); // true
        System.out.println(isBalanced(zero)); // true
    }
}
