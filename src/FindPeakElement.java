public class FindPeakElement {
    public static int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 1};
        System.out.println(findPeakElement(input)); // idx 3
    }
}
