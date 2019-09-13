import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        pathSum(root, new ArrayList<>(), paths, sum, 0);
        return paths;
    }

    public static void pathSum(TreeNode root, List<Integer> path, List<List<Integer>> paths, int sum, int pathSum) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        int currSum = pathSum + root.val;
        if (root.left == null && root.right == null && currSum == sum) {
            paths.add(new ArrayList<>(path));
        }
        pathSum(root.left, path, paths, sum, currSum);
        pathSum(root.right, path, paths, sum, currSum);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode five = new TreeNode(5);
        TreeNode four = new TreeNode(4);
        TreeNode eight = new TreeNode(8);
        TreeNode eleven = new TreeNode(11);
        TreeNode thirteen = new TreeNode(13);
        TreeNode four1 = new TreeNode(4);
        TreeNode seven = new TreeNode(7);
        TreeNode two = new TreeNode(2);
        TreeNode one  = new TreeNode(1);
        five.left = four;
        five.right = eight;
        four.left = eleven;
        eight.left = thirteen;
        eight.right = four1;
        eleven.left = seven;
        eleven.right = two;
        four1.right = one;

        System.out.println(pathSum(five, 22));
    }
}
