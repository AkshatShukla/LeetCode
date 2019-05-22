import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NextGreaterNodeInLinkedList {
    /*
    Use ArrayList to save the value of each node;
    Use Stack to maintain the indices of a descending sequence;
    Traverse the ListNodes, whenever encountering a new node greater than the element corresponding to the top of the stack, keep popping it out till the stack is empty or the new one is no longer greater; For each poped out index, set the corresponding element in the ArrayList with the new node value.
    After the traversal, those remaining in stack are indices of elements without next greater node; Set them to 0.
     */

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> s = new ArrayDeque<>();
        ListNode current = head;
        while (current != null) {
            while (!s.isEmpty() && current.val > result.get(s.peek())) {
                result.set(s.pop(), current.val); // see 3. for details.
            }
            s.push(result.size()); // push into stack the index of the element that has not found next greater node yet.
            result.add(current.val); // add the new node value.
            current = current.next;
        }
        for (int i : s) {
            result.set(i, 0); // now stack contains only indices of nodes without next greater node.
        }
        return result.stream().mapToInt(i -> i).toArray(); // convert ArrayList to int[].
    }
}
