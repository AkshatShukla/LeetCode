import java.util.*;

public class FindAllDuplicatedInAnArray {
    public static List<Integer> findDuplicatesNaive(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        Set<Integer> unique = new HashSet<>();

        for (int num : nums) {
            if (!unique.add(num)) {
                duplicates.add(num);
            }
        }

        return duplicates;
    }

    public static List<Integer> findDuplicatesEfficient(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        // mark i-1th index for number i as negative
        // if the number at position i - 1 is already negative, then ith number is duplicate

        for (int i = 0; i < nums.length; i++) {
            int convertedIndex = Math.abs(nums[i]) - 1; // convert value to index by subtracting 1;
            if (nums[convertedIndex] < 0) {
                // if its already negative, we have seen that, and hence add it to duplicates
                duplicates.add(Math.abs(nums[i])); // Add the value of num by converting back the index to 1;
            }
            nums[convertedIndex] = -nums[convertedIndex]; // flip sign
        }

        // revert back the array to the way it was
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }

        return duplicates;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicatesNaive(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(findDuplicatesEfficient(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }
}
