import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static int[] searchRange(int[] nums, int target) {
        int[] range = new int[2];
        range[0] = -1;
        range[1] = -1;
        if (nums == null || nums.length == 0) {
            return range;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                int left = mid;
                while (left - 1 >= 0 && nums[left] == nums[left - 1]) {
                    left--;
                }
                range[0] = left;
                int right = mid;
                while (right + 1 < nums.length && nums[right] == nums[right + 1]) {
                    right++;
                }
                range[1] = right;
                break;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] == target) {
            range[0] = start;
            while (start + 1 < nums.length && nums[start] == nums[start + 1]) {
                start++;
            }
            range[1] = start;
        } else if (nums[end] == target) {
            range[1] = end;
            while (end - 1 >= 0 && nums[end] == nums[end - 1]) {
                end--;
            }
            range[0] = end;
        }
        return range;
    }

    public static int[] searchRange2(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        // [5, 7, 8, 8, 8, 10]
        //
        // low: 0
        // high: 5
        // mid: 2
        // target: 8
        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                return new int[]{findLeft(nums, 0, mid, target), findRight(nums, mid, nums.length - 1, target)};
            }
        }

        return new int[]{-1, -1};
    }

    private static int findLeft(int[] nums, int low, int high, int target) {
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (mid > 0 && nums[mid - 1] < target) {
                return mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private static int findRight(int[] nums, int low, int high, int target) {
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (mid < nums.length && nums[mid + 1] > target) {
                return mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = searchRange(nums, target);
        System.out.println(result[0] + " " + result[1]);
        System.out.println(searchRange(new int[]{1}, 1)[0]);
        System.out.println(searchRange(new int[]{2, 2}, 2)[1]);
        System.out.println(Arrays.toString(searchRange2(nums, 8)));
        System.out.println(Arrays.toString(searchRange2(nums, 7)));
    }
}
