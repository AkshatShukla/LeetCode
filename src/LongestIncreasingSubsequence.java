import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1); // default value at each subproblem
        int maxAns = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1); // can we extend the sub-sequence?
                }
            }
            maxAns = Math.max(maxAns, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return maxAns;
    }

    public static int lengthofLISEfficient(int[] nums) {
        int[] sortedArray = new int[nums.length];
        int size = 0;
        for (int num : nums) {
            System.out.println(Arrays.toString(sortedArray));
            int start = 0;
            int end = size; // 1 element past end of our sortedArray
            while (start != end) {
                int mid = (start + end) / 2;
                if (sortedArray[mid] < num) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            sortedArray[start] = num;
            if (start == size) {
                size++;
            }
        }
        return size;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{-1, 3, 4, 5, 2, 2, 2};
        int[] ints1 = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int[] ints2 = new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6};
//        System.out.println(lengthOfLIS(ints));
//        System.out.println(lengthOfLIS(ints1));
//        System.out.println(lengthOfLIS(ints2));
        System.out.println(lengthofLISEfficient(ints));
        System.out.println(lengthofLISEfficient(ints1));
        System.out.println(lengthofLISEfficient(ints2));
    }
}
