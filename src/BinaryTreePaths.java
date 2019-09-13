import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> ListOfPaths = new ArrayList<>();
        if (root == null)
            return ListOfPaths;

        if (root.left == null && root.right == null) {
            ListOfPaths.add(Integer.toString(root.val));
            return ListOfPaths;
        }

        if (root.left != null)
            buildList(root.left, ListOfPaths, Integer.toString(root.val));
        if (root.right != null)
            buildList(root.right, ListOfPaths, Integer.toString(root.val));

        return ListOfPaths;
    }

    public static void buildList(TreeNode root, List<String> paths, String currPath) {
        currPath += "->" + root.val;
        if (root.left == null && root.right == null) {
            paths.add(currPath);
        } else if (root.left == null) {
            buildList(root.right, paths, currPath);
        } else if (root.right == null) {
            buildList(root.left, paths, currPath);
        } else {
            buildList(root.left, paths, currPath);
            buildList(root.right, paths, currPath);
        }
    }
}
