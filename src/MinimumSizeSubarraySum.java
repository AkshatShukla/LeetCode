public class MinimumSizeSubarraySum {
    public static int minSubArrayLen(int s, int[] nums) {
        // [2,3,1,2,4,3]
        int sum = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        // minimize end - start and sum >= s;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                minLen = Math.min(minLen, i + 1 - start);
                sum -= nums[start];
                start++;
            }
        }

        return minLen != Integer.MAX_VALUE ? minLen : 0;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        // the subarray [4,3] has the minimal length under the problem constraint.
    }
}
