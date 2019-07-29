public class RotateArray {
    public static void rotate(int[] nums, int k) {
        // n-k (size of A) , k (size of B)
        // rev (A) and then rev (B)
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public static void reverse(int[] arr, int low, int high) {
        while (low < high) {
            int temp = arr[high];
            arr[high] = arr[low];
            arr[low] = temp;
            low++;
            high--;
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        rotate(nums, 3);
        for (int i:nums) {
            System.out.println(i); // [5, 6, 7, 1, 2, 3, 4]
        }
        int[] nums2 = new int[]{-1};
        rotate(nums2, 2);
    }
}
