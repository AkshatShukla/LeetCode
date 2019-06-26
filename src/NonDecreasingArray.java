public class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        Integer count = null;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (count != null) {
                    return false;
                }
                count = i;
            }
        }
        System.out.println(count);
        return count == null || count == 0 || count == nums.length - 2 || nums[count - 1] <= nums[count + 1] || nums[count] <= nums[count + 2];
    }
}
