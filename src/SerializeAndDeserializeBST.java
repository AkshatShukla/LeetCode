import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBST {
    // use upper and lower boundaries to check whether we should add null
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    public static void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        } else {
            sb.append(root.val).append(",");
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static TreeNode deserialize(Queue<String> q, int minBound, int maxBound) {
        if (q.isEmpty()) {
            return null;
        }
        String s = q.peek();
        int val = Integer.valueOf(s);
        if (val < minBound || val > maxBound) {
            // leaf
            return null;
        }
        q.poll();
        TreeNode root = new TreeNode(val);
        root.left = deserialize(q, minBound, val);
        root.right = deserialize(q, val, maxBound);
        return root;
    }

    public static void main(String[] args) {
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

        System.out.println(serialize(one));
        System.out.println(deserialize(serialize(one)));
    }
}
