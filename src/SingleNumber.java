public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,2,3,3,1};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        // a ^ 0 = a
        // a ^ a = 0
        int res = 0;
        for (int n : nums) {
            res ^= n;
        }
        return res;
    }
}
