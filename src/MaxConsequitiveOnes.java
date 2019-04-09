public class MaxConsequitiveOnes {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,0,0,1,1,1,0,0,1,1,1,1,1};
        int j = 0, max_1 = 0;
        for (int num : nums) {
            if (num == 1) {
                j = j + 1;
            } else {
                if (j >= max_1)
                    max_1 = j;
                j = 0;
            }
        }
        System.out.println(Integer.max(max_1,j));
    }
}
