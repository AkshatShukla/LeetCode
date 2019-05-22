import java.util.Stack;

public class RangeOfBST {
    public int rangeSumBST(TreeNode root, int L, int R) {
        /*
        We traverse the tree using a depth first search. If node.val falls outside the range [L, R],
        (for example node.val < L), then we know that only the right branch could have nodes with value inside [L, R].
         */
        int ans = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (L <= node.val && node.val <= R)
                    ans += node.val;
                if (L < node.val)
                    stack.push(node.left);
                if (node.val < R)
                    stack.push(node.right);
            }
        }
        return ans;
    }

    public static int rangeSumBSTRecursive(TreeNode root, int L, int R) {
        if (root == null) { return 0; }
        int sum = 0;
        if (root.val > L) { sum += rangeSumBSTRecursive(root.left, L, R); } // left child is a possible candidate.
        if (root.val < R) { sum += rangeSumBSTRecursive(root.right, L, R); } // right child is a possible candidate.
        if (root.val >= L && root.val <= R) { sum += root.val; } // count root in.
        return sum;
    }
}
