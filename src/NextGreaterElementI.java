import java.util.*;

public class NextGreaterElementI {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        /*
        Key observation:
        Suppose we have a decreasing sequence followed by a greater number
        For example [5, 4, 3, 2, 1, 6] then the greater number 6 is the next greater element for all previous numbers in
        the sequence

        We use a stack to keep a decreasing sub-sequence, whenever we see a number x greater than stack.peek() we pop all
        elements less than x and for all the popped ones, their next greater element is x
        For example [9, 8, 7, 3, 2, 1, 6]
        The stack will first contain [9, 8, 7, 3, 2, 1] and then we see 6 which is greater than 1 so we pop 1 2 3 whose
        next greater element should be 6
         */
        int[] result = new int[nums1.length];
        Deque<Integer> stack = new LinkedList<>();
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int value : nums2) {
            while (!stack.isEmpty() && stack.peekFirst() < value) {
                hashMap.put(stack.removeFirst(), value);
            }
            stack.addFirst(value);
        }
        System.out.println(hashMap);
        for (int i = 0; i<nums1.length; i++) {
            int res = hashMap.getOrDefault(nums1[i], -1);
            result[i] = res;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 1, 2};
        int[] nums2 = new int[]{1, 3, 4, 2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2))); // [-1, 3, -1]
    }
}
