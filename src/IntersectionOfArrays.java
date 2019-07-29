import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 1, 2, 2};
        int[] nums2 = new int[]{2, 2};
        int[] ans = intersect(nums1, nums2);
        for (int i : ans)
            System.out.println(i);
    }

    private static int[] intersect(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int n : nums1) {
            set1.add(n);
        }

        for (int n : nums2) {
            set2.add(n);
        }

        set1.retainAll(set2);

        int[] res = new int[set1.size()];
        int j = 0;
        for (int i : set1) {
            res[j] = i;
            j++;
        }
        return res;
    }
}
