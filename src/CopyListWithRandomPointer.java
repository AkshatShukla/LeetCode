import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> nodeRandMap = new HashMap<>();

        Node curr = head;

        while (curr != null) {
            nodeRandMap.put(curr, new Node(curr.val, curr.next, curr.random));
            curr = curr.next;
        }

        curr = head;

        while (curr != null) {
            nodeRandMap.get(curr).next = nodeRandMap.get(curr.next);
            nodeRandMap.get(curr).random = nodeRandMap.get(curr.random);
            curr = curr.next;
        }
        return nodeRandMap.get(head);
    }
}
