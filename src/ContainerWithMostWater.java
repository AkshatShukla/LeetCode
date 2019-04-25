public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int max_area = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;
        while (left <= right) {
            max_area = Math.max(max_area, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return max_area;
    }

    public static void main(String[] args) {
        int[] h = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(h));
    }
}
