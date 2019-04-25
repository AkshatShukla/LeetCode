import java.util.Collections;

public class TwoSumII {
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int[] res = new int[2];

        while (left < right) {
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                res[0] = left+1;
                res[1] = right+1;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 17;
        for (int n:twoSum(nums, target)) {
            System.out.println(n);
        }
    }
}
