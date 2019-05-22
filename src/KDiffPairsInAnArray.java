import java.util.HashMap;
import java.util.Map;

public class KDiffPairsInAnArray {
    public static int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return 0;
        }

        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i : nums) {
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }

        int count = 0;

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (k == 0) {
                //count how many elements in the array that appear more than twice.
                if (entry.getValue() >= 2) {
                    count++;
                }
            } else {
                if (hashMap.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] input1 = new int[]{3, 1, 4, 1, 5};
        int[] input2 = new int[]{1, 2, 3, 4, 5};
        int[] input3 = new int[]{1, 3, 1, 5, 4};
        System.out.println(findPairs(input1, 2)); // 2 : (1, 3) and (3, 5)
        System.out.println(findPairs(input2, 1)); // 4 : 1, 2), (2, 3), (3, 4) and (4, 5)
        System.out.println(findPairs(input3, 0)); // 1 : (1, 1)
    }
}
