public class MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int max = nums[0], min = nums[0], result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Store the max value because we need it to multiple it to find the min but would be updated in the next step. 
            int temp = max;

            // Find the Maximum of : 
            // ------> (1) nums[i]        
            // ------> (2) nums[i] * max  
            // ------> (3) nums[i] * min  
            max = Math.max(nums[i], Math.max(nums[i] * max, nums[i] * min));

            // Find the minimum of : 
            // ------> (1) nums[i]         
            // ------> (2) nums[i] * max (temp in this case since max is updated in the above step)  
            // ------> (3) nums[i] * min  

            min = Math.min(nums[i], Math.min(nums[i] * temp, nums[i] * min));

            // Result is the max of the previous result and the current max.
            result = Math.max(result, max);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{2, 3, -2, 4};
        int[] ints1 = new int[]{-2, 0, -1};
        int[] ints2 = new int[]{0, 2};
        int[] ints3 = new int[]{-2, 3, -4};
        System.out.println(maxProduct(ints)); // 6
        System.out.println(maxProduct(ints1)); // 0
        System.out.println(maxProduct(ints2)); // 2
        System.out.println(maxProduct(ints3)); // 24
    }
}
