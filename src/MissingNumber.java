public class MissingNumber {
    public static void main(String[] args) {
        int[] ints = new int[]{3,0,1};
        System.out.println(missingNumber(ints));
    }

    private static int missingNumber(int[] nums) {
        int expectedSum = (nums.length*(nums.length+1)) / 2;
        int actualSum = 0;
        for (int n : nums)
            actualSum += n;
        return expectedSum - actualSum;
    }
}
