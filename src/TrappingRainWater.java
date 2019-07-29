public class TrappingRainWater {
    public static int trapNaive(int[] height) {
        int total_water = 0;

        for (int i = 1; i < height.length; i++) {
            int left_max = 0;
            int right_max = 0;

            for (int j = 0; j <= i; j++) {
                left_max = Math.max(left_max, height[j]);
            }

            for (int k = i; k < height.length; k++) {
                right_max = Math.max(right_max, height[k]);
            }

            int water_at_i = Math.min(left_max, right_max) - height[i];
            total_water += water_at_i;
        }

        return total_water;
    }

    public static int trapDynamic(int[] height) {
        int total_water = 0;
        int size = height.length;

        if (size == 0) {
            return 0;
        }

        // max height from left to right upto the index i
        int[] left_max = new int[size];
        // max height from right to left upto the index i
        int[] right_max = new int[size];

        left_max[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            left_max[i] = Math.max(height[i], left_max[i - 1]);
        }

        right_max[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            right_max[i] = Math.max(height[i], right_max[i + 1]);
        }

        for (int i = 1; i < height.length; i++) {
            int water_at_i = Math.min(left_max[i], right_max[i]) - height[i];
            total_water += water_at_i;
        }

        return total_water;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trapNaive(height));
        System.out.println(trapDynamic(height));
    }
}
