public class SplitArrayLargestSum {
    // search range
    // elements need to be sorted
    // consider entire array as 1 subarray, max sum is sum(nums)
    // consider individual 1 element subarrays, then max sum is max(nums)
    // search range: [max(nums), sum(nums)]
    // constraints: m, largestSum
    // we need to get pieces, so if pieces > m, largestSum is too small
    /*
    The answer is between maximum value of input array numbers and sum of those numbers.
    Use binary search to approach the correct answer. We have l = max number of array; r = sum of all numbers in the
    array;Every time we do mid = (l + r) / 2;
    Use greedy to narrow down left and right boundaries in binary search.
    3.1 Cut the array from left.
    3.2 Try our best to make sure that the sum of numbers between each two cuts (inclusive) is large enough but still less than mid.
    3.3 We'll end up with two results: either we can divide the array into more than m subarrays or we cannot.
    If we can, it means that the mid value we pick is too small because we've already tried our best to make sure each part
     holds as many non-negative numbers as we can but we still have numbers left. So, it is impossible to cut the array into m parts
      and make sure each parts is no larger than mid. We should increase m. This leads to l = mid + 1;
    If we can't, it is either we successfully divide the array into m parts and the sum of each part is less than mid, or we
    used up all numbers before we reach m. Both of them mean that we should lower mid because we need to find the minimum one.
    This leads to r = mid - 1;
     */
    public static int splitArray(int[] nums, int m) {
        int n = nums.length;
        int max = 0;
        int sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        int low = max;
        int high = sum;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int pieces = split(nums, mid);
            if (pieces > m) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static int split(int[] nums, int largestSum) {
        int pieces = 1;
        int tmpSum = 0;
        for (int num : nums) {
            if (tmpSum + num > largestSum) {
                tmpSum = num;
                pieces++;
            } else {
                tmpSum += num;
            }
        }
        return pieces;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{7,2,5,10,8};
        System.out.println(splitArray(ints, 2));
        /*
        There are four ways to split nums into two subarrays.
        The best way is to split it into [7,2,5] and [10,8],
        where the largest sum among the two subarrays is only 18.
         */
    }
}
