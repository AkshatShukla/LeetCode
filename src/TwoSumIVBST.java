import java.util.ArrayList;
import java.util.List;

public class TwoSumIVBST {
    public static boolean findTarget(TreeNode root, int k) {
        // inorder traversal of tree, gives sorted array. Then just apply binary search and get the result

        List<Integer> inorderList = new ArrayList<>();

        traverseInorder(root, inorderList);

        int low = 0;
        int high = inorderList.size() - 1;

        while (low < high) {
            if (inorderList.get(low) + inorderList.get(high) == k) {
                return true;
            } else if (inorderList.get(low) + inorderList.get(high) > k) {
                high--;
            } else if (inorderList.get(low) + inorderList.get(high) < k) {
                low++;
            }
        }

        return false;
    }

    private static void traverseInorder(TreeNode root, List<Integer> list) {
        if (root != null) {
            if (root.left != null) {
                traverseInorder(root.left, list);
            }
            list.add(root.val);
            if (root.right != null) {
                traverseInorder(root.right, list);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode five = new TreeNode(5);
        TreeNode three = new TreeNode(3);
        TreeNode six = new TreeNode(6);
        TreeNode two = new TreeNode(2);
        TreeNode four = new TreeNode(4);
        TreeNode seven = new TreeNode(7);

        five.left = three;
        five.right = six;
        three.left = two;
        three.right = four;
        six.right = seven;

        System.out.println(findTarget(five, 9)); // true
        System.out.println(findTarget(five, 28)); // false
    }
}
