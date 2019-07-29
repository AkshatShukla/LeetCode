import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums); // O(NlogN)

        for (int i = 0; i <= nums.length - 3; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
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

    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            twoSum(nums, result, target, left, right);
        }

        return result;
    }

    private static void twoSum(int[] nums, List<List<Integer>> result, int target, int left, int right) {
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                List<Integer> triplet = new ArrayList<>();
                triplet.add(-target);
                triplet.add(nums[left]);
                triplet.add(nums[right]);
                result.add(triplet);
                left++;
                right--;
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            }
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(input));
    }
}
