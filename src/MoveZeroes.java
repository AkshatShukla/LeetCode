public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
        for (int c:nums)
            System.out.println(c);

    }

    private static void moveZeroes(int[] nums) {
        int i = 0;
        for (int j=0;j<nums.length;j++) {
            if (nums[j] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
        }
    }
}
