import java.util.ArrayList;

public class LeafSimilarTrees {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode l = new TreeNode(5);
        TreeNode r = new TreeNode(1);
        TreeNode ll = new TreeNode(6);
        TreeNode lr = new TreeNode(2);
        TreeNode rl = new TreeNode(9);
        TreeNode rr = new TreeNode(8);
        TreeNode lrl = new TreeNode(7);
        TreeNode lrr = new TreeNode(4);
        root.left = l;
        root.right = r;
        l.left = ll;
        l.right = lr;
        r.left = rl;
        r.right = rr;
        lr.left = lrl;
        lr.right = lrr;
        TreeNode root1 = new TreeNode(5);
        System.out.println(leafSimilar(root, root1));
    }

    private static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> leaves1 = new ArrayList<>();
        ArrayList<Integer> leaves2 = new ArrayList<>();
        dfs(root1,leaves1);
        dfs(root2,leaves2);
        return leaves1.equals(leaves2);
    }

    private static void dfs(TreeNode root, ArrayList<Integer> leaves) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                leaves.add(root.val);
            }
            dfs(root.left,leaves);
            dfs(root.right,leaves);
        }
    }
}
