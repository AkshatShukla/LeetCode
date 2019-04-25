import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            boolean result = set.add(num);
            if (!result) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        int[] nums2 = {1, 2, 3, 4};
        System.out.println(containsDuplicate(nums)); //True
        System.out.println(containsDuplicate(nums2)); //False
     }
}
