import java.util.HashMap;

public class SubarraySumEqualsK {
    public static int subarraySumNaive(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end <= nums.length; end++) {
                int sum = 0;
                for (int i = start; i < end; i++) {
                    sum += nums[i];
                }
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    /*
    The idea behind this approach is as follows: If the cumulative sum(repreesnted by sum[i]sum[i] for sum upto
    i^{th}ith index) upto two indices is the same, the sum of the elements lying in between those indices is zero.
    Extending the same thought further, if the cumulative sum upto two indices, say ii and jj is at a difference of k
    i.e. if sum[i] - sum[j] = ksum[i]−sum[j]=k, the sum of elements lying between indices ii and jj is kk.

    Based on these thoughts, we make use of a hashmap mapmap which is used to store the cumulative sum upto all the
    indices possible along with the number of times the same sum occurs. We store the data in the form: (sum_i, no. of
    occurences of sum_i)(sum i,no.of occurences of sum i). We traverse over the array numsnums and keep on finding the
    cumulative sum. Every time we encounter a new sum, we make a new entry in the hashmap corresponding to that sum.
    If the same sum occurs again, we increment the count corresponding to that sum in the hashmap. Further, for every
    sum encountered, we also determine the number of times the sum sum-ksum−k has occured already, since it will
    determine the number of times a subarray with sum kk has occured upto the current index. We increment the count
     by the same amount.
     */

    public static int subarraySumEfficient(int[] nums, int k) {
        int count = 0;
        int sumSoFar = 0;
        // Map sum to its frequency
        HashMap<Integer, Integer> sumFreqMap = new HashMap<>();
        sumFreqMap.put(0, 1);

        for (int num : nums) {
            sumSoFar += num;
            if (sumFreqMap.containsKey(sumSoFar - k)) {
                count += sumFreqMap.get(sumSoFar - k);
            }
            sumFreqMap.put(sumSoFar, sumFreqMap.getOrDefault(sumSoFar, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySumNaive(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySumEfficient(new int[]{1, 1, 1}, 2));
    }
}
