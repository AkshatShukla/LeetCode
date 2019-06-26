import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    // O(nlogn)
    // O(1)
    public static int longestConsecutive1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int longestStreak = 1;
        int currentStreak = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] == nums[i - 1] + 1) {
                    currentStreak += 1;
                } else {
                    longestStreak = Math.max(longestStreak, currentStreak);
                    currentStreak = 1;
                }
            }
        }

        return Math.max(longestStreak, currentStreak);
    }

    public static int longestConsecutive2(int[] nums) {
        Set<Integer> values = new HashSet<>();

        for (int num : nums) {
            values.add(num);
        }

        int max = 0;

        for (int n : values) {
            if (values.contains(n - 1)) continue; // already a number which is part of a sequence (longest or otherwise)
            // else n is a start of new sequence, as there is not number less than n in set.
            int length = 0;
            while (values.contains(n)) {
                n++;
                length++;
            }
            max = Math.max(max, length);
        }

        return max;
    }

    public static void main(String[] args) {
//        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(longestConsecutive1(new int[]{4, 2, 1, 6, 5}));
        System.out.println(longestConsecutive2(new int[]{4, 2, 1, 6, 5}));
    }
}
