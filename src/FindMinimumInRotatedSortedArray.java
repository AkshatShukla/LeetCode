public class FindMinimumInRotatedSortedArray {
    public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[high] < nums[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[high];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 5, 1, 2}; // 1
        int[] nums2 = new int[]{4, 5, 6, 7, 0, 1, 2}; // 0
        System.out.println(findMin(nums));
        System.out.println(findMin(nums2));
    }
}
