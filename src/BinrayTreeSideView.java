import java.util.ArrayList;
import java.util.List;

public class BinrayTreeSideView {
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverseRight(root, result, 0);
        return result;
    }

    public static void traverseRight(TreeNode root, List<Integer> result, int currDepth) {
        /*
        The core idea of this algorithm:

            1.Each depth of the tree only select one node.
            2. View depth is current size of result list.
        */

        if(root == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(root.val);
        }
        traverseRight(root.right, result, currDepth + 1);
        traverseRight(root.left, result, currDepth + 1);
    }

    public static List<Integer> leftSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverseLeft(root, 0, result);
        return result;
    }

    public static void traverseLeft(TreeNode root, int level, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (result.size() == level) {
            result.add(root.val);
        }
        traverseLeft(root.left, level + 1, result);
        traverseLeft(root.right, level + 1, result);
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        one.left = two;
        one.right = three;
        three.right = four;
        two.right = five;

        System.out.println(rightSideView(one)); // [1, 3, 4]
        System.out.println(leftSideView(one));
    }
}
