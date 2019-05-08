import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBST {

    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal(root, res);
        // kth element from front of this list is the kth smallest, kth element from back of the list is kth largest
        return res.get(k-1);
    }

    public static void inorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, res);
        res.add(root.val);
        inorderTraversal(root.right, res);
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);

        five.left = three;
        five.right = six;
        three.left = two;
        three.right = four;
        two.left = one;
//
//        three.left = one;
//        three.right = four;
//        one.right = two;
        System.out.println(kthSmallest(five, 3));
//        System.out.println(kthSmallest(three, 1));
    }
}
