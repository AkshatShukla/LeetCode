import java.util.NoSuchElementException;

class Node {
    int value;
    int minSoFar;
    Node next;
    public Node(int x) { value = x; minSoFar = x; }
}

public class MinStack {
    public static void main(String[] args) {
        int x = 0;
        MinStack obj = new MinStack();
        obj.push(x);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
    }

    Node top;
    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        Node newTop = new Node(x);
        newTop.next = top;
        if (top!=null) {
            if (newTop.value < top.minSoFar)
                newTop.minSoFar = newTop.value;
            else
                newTop.minSoFar = top.minSoFar;
        }
        top = newTop;
    }

    public void pop() {
        if (top == null)
            throw new NoSuchElementException();
        top = top.next;
    }

    public int top() {
        if (top == null)
            throw new NoSuchElementException();
        return top.value;
    }

    public int getMin() {
        if (top == null)
            throw new NoSuchElementException();
        return top.minSoFar;
    }
}
