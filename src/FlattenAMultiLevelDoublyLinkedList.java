import java.util.Stack;

public class FlattenAMultiLevelDoublyLinkedList {
    public static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    };

    public static Node flatten(Node head) {
        if (head == null)
            return head;

        Stack<Node> stack = new Stack<>();

        Node curr = head;

        while (curr != null) {
            if (curr.child != null) {
                if (curr.next != null) {
                    stack.push(curr.next);
                }
                curr.next = curr.child;
                if (curr.next != null) {
                    curr.next.prev = curr;
                }
                curr.child = null;
            } else if (curr.next == null && !stack.isEmpty()) {
                curr.next = stack.pop();
                if (curr.next != null) {
                    curr.next.prev = curr;
                }
            }
            curr = curr.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Node one = new Node();
        Node two = new Node();
        Node three = new Node();
        Node four = new Node();
        Node five = new Node();
        Node six = new Node();
        Node seven = new Node();
        Node eight = new Node();
        one = new Node(1, null, two, null);
        two = new Node(2, one, three, null);
        three = new Node(3, two, four, six);
        four = new Node(4, three, null, null);
        six = new Node(6, null, seven, null);
        seven = new Node(7, six, eight, null);
        eight = new Node(8, seven, null, null);
        Node newHead = flatten(one);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }

    }
}
