public class LongestContinousIncreasingSubsequence {
    public static int findLengthOfLCIS(int[] nums) {
        int anchor = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] >= nums[i]) {
                anchor = i;
            }
            ans = Math.max(ans, i - anchor + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1, 3, 5, 4, 7};
        System.out.println(findLengthOfLCIS(ints));
    }
}
