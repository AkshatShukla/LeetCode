import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,1,2,2};
        int[] nums2 = new int[]{2,2};
        int[] ans = intersect(nums1,nums2);
        for (int i:ans)
            System.out.println(i);
    }

    private static int[] intersect(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int start1 = 0;
        int start2 = 0;
        while (start1 < nums1.length && start2 < nums2.length) {
            if (nums1[start1] < nums2[start2])
                start1++;
            else if (nums1[start1] > nums2[start2])
                start2++;
            else {
                result.add(nums1[start1]);
                start1++;
                start2++;
            }
        }
        int[] res = new int[result.size()];
        int j = 0;
        for (int i:result) {
            res[j] = i;
            j++;
        }
        return res;
    }
}
