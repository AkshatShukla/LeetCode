public class ShortestUnsortedContinuousSubarray {
    public static int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                min = Math.min(min, nums[i]);
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1])
                max = Math.max(max, nums[i]);
        }

        int left = 0, right = nums.length - 1;
        while (left < nums.length) {
            if (min < nums[left])
                break;
            left++;
        }
        while (right >= 0) {
            if (max > nums[right])
                break;
            right--;
        }

        return right - left < 0 ? 0 : right - left + 1;
    }

    public static void main(String[] args) {
        int[] ints = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarray(ints));
        // You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
    }
}
