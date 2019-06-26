import java.util.HashMap;
import java.util.Map;

public class SubarraySumDivisbleByK {
    public static int subarraysDivByK(int[] A, int K) {
        int count = 0;
        int sumSoFar = 0;
        // Map remainder to its frequency
        Map<Integer, Integer> remFreqMap = new HashMap<>();
        remFreqMap.put(0, 1);

        for (int num : A) {
            sumSoFar += num;
            // If a % k = b % k then (b - a) % k = 0
            // Please note that when calculate sum % K for sum < 0, we keep adding K to sum until sum is above 0 then
            // mod K.
            int remainder = (sumSoFar % K + K) % K;
            if (remFreqMap.containsKey(remainder)) {
                count += remFreqMap.get(remainder);
            }
            remFreqMap.put(remainder, remFreqMap.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
        /*
        There are 7 subarrays with a sum divisible by K = 5:
        [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
         */
    }
}
