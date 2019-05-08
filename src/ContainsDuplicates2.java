import java.util.*;

public class ContainsDuplicates2 {
    public static boolean containsNearbyDuplicateBrute(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && Math.abs(i - j) <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containsNearbyDuplicateEfficient(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 1, 2, 3};
        int[] input2 = new int[]{1, 2, 3, 1};
        int[] input3 = new int[]{99, 99};
        int[] input4 = new int[]{1, 0, 1, 1};
        System.out.println(containsNearbyDuplicateBrute(input, 2)); // false
        System.out.println(containsNearbyDuplicateBrute(input2, 3)); // true
        System.out.println(containsNearbyDuplicateBrute(input3, 2)); // true
        System.out.println(containsNearbyDuplicateEfficient(input, 2)); // false
        System.out.println(containsNearbyDuplicateEfficient(input2, 3)); // true
        System.out.println(containsNearbyDuplicateEfficient(input3, 2)); // true
        System.out.println(containsNearbyDuplicateEfficient(input4, 1)); // true
    }
}
