class LLNode {
    int val;
    LLNode next;

    LLNode(int x) {
        val = x;
        next = null;
    }
}

/*
Actually we don't care about the "value" of difference, we just want to make sure two pointers reach the intersection node at the same time.

We can use two iterations to do that. In the first iteration, we will reset the pointer of one linkedlist to the head of another linkedlist
after it reaches the tail node. In the second iteration, we will move two pointers until they points to the same node. Our operations in
first iteration will help us counteract the difference. So if two linkedlist intersects, the meeting point in second iteration must be the
intersection point. If the two linked lists have no intersection at all, then the meeting pointer in second iteration must be the tail node
 of both lists, which is null

 As mentioned by @user4606 , it will terminate at the end of the second loop.

Notice that after 2 loops, a will go through List A and List B, b will go through List B and List A. So eventually after 2 loops,
a will have moved totally len(A + B) steps, meanwhile, b will have moved totally len(B + A), therefore it's guaranteed that a and b
will meet at the end of the second loop, regardless of whether len(A) == len(B) or not. So no flag is needed.

In the case of List A and B having no interactions, a and b will meet at the end of the second loop, when both a and b are equal to null,
 also mentioned by @Elynn.

I like this solution.
 */

public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        LLNode headA = new LLNode(10);
        LLNode headB = new LLNode(20);
        LLNode a = new LLNode(25);
        LLNode b = new LLNode(45);
        LLNode c = new LLNode(30);
        LLNode d = new LLNode(90);
        headA.next = a;
        headB.next = b;
        b.next = c;
        c.next = a;
        a.next = d;
        System.out.println(getIntersectionNode(headA, headB).val);
    }

    private static LLNode getIntersectionNode(LLNode headA, LLNode headB) {
        if (headA == null || headB == null) return null;

        LLNode a = headA;
        LLNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while (a != b) {
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
//            a = a == null ? headB : a.next;
//            b = b == null ? headA : b.next;
            if (a == null)
                a = headB;
            else
                a = a.next;
            if (b == null)
                b = headA;
            else
                b = b.next;
        }

        return a;
    }
}
