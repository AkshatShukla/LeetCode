import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int min = 1; // first positive number
        while (set.contains(min)) {
            min++;
        }
        return min;
    }

    // [3,4,-1,1]
    public static int firstMissingPositiveEfficient(int[] nums) {
        // The basic idea is to traversal and try to move the current value to position whose index is exactly the value
        // (swap them). Then travelsal again to find the first unusal value, which can not be corresponding to its index.
        int len = nums.length;
        int i = 0;
        while (i < nums.length) {
            // If the current value is in the range of (0,length) and it's not at its correct position,
            // swap it to its correct position.
            // Else just continue;
            if (nums[i] >= 0 && nums[i] < len && nums[nums[i]] != nums[i])
                swap(nums, i, nums[i]);
            else
                i++;
        }
        int k = 1;

        // Check from k=1 to see whether each index and value can be corresponding.
        while (k < len && nums[k] == k)
            k++;

        // If it breaks because of empty array or reaching the end. K must be the first missing number.
        if (len == 0 || k < len)
            return k;
        else   // If k is hiding at position 0, K+1 is the number.
            return nums[0] == k ? k + 1 : k;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1, 0, 2, 3})); // 4
        System.out.println(firstMissingPositiveEfficient(new int[]{1, 0, 2, 3}));
    }
}
