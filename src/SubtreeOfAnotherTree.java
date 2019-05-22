public class SubtreeOfAnotherTree {
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        if (isSame(s, t)) {
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private static boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }

    public static void main(String[] args) {
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        three.left = four;
        three.right = five;
        four.left = one;
        four.right = two;

        TreeNode four1 = new TreeNode(4);
        TreeNode one1 = new TreeNode(1);
        TreeNode two1 = new TreeNode(2);
        four1.left = one1;
        four1.right = two1;

        System.out.println(isSubtree(four, four1)); // true
        TreeNode zero = new TreeNode(0);
        two1.left = zero;
        System.out.println(isSubtree(four, four1)); // false
    }
}
