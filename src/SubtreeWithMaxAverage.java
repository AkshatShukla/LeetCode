import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubtreeWithMaxAverage {
    static double max = Integer.MIN_VALUE;
    static Node maxNode = null;

    static class Node {
        int val;
        List<Node> children;

        Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    public static Node maximumAverageSubtree(Node root) {
        if (root == null) return null;
        helper(root);
        return maxNode;
    }

    private static double[] helper(Node root) {
        if (root == null) return new double[]{0, 0};

        double curTotal = root.val;
        double count = 1;
        for (Node child : root.children) {
            double[] cur = helper(child);
            curTotal += cur[0];
            count += cur[1];
        }
        double avg = curTotal / count;
        if (count > 1 && avg > max) { //taking "at least 1 child" into account
            max = avg;
            maxNode = root;
        }
        return new double[]{curTotal, count};
    }

    public static void main(String[] args) {
        Node eleven = new Node(11, new ArrayList<>());
        Node two = new Node(2, new ArrayList<>());
        Node three = new Node(3, new ArrayList<>());
        Node twelve = new Node(12, new ArrayList<>(Arrays.asList(eleven, two, three)));
        Node fifteen = new Node(15, new ArrayList<>());
        Node eight = new Node(8, new ArrayList<>());
        Node eighteen = new Node(18, new ArrayList<>(Arrays.asList(fifteen, eight)));
        Node twenty = new Node(20, new ArrayList<>(Arrays.asList(twelve, eighteen)));
        System.out.println(maximumAverageSubtree(twenty).val);
    }
}
