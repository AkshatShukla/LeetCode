import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums); // O(NlogN)

        for (int i=0; i<=nums.length-3; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int start = i + 1;
                int end = nums.length - 1;
                while (start < end) {
                    int sum = nums[i] + nums[start] + nums[end];
                    if (sum == 0) {
                        List<Integer> list = Arrays.asList(nums[i], nums[start], nums[end]);
                        results.add(list);
                    } else if (sum < 0) {
                        int currentStart = start;
                        while (nums[currentStart] == nums[start] && start < end) {
                            start++;
                        }
                    } else {
                        int currentEnd = end;
                        while (nums[currentEnd] == nums[end] && start < end) {
                            end--;
                        }
                    }
                }
            }
        }

        return results;
    }

    public static void main(String[] args) {
        int[] input = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(input));
    }
}
