import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSumUniquePairs {
    public static int getUniquePairsOpti(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                int key = map.get(num) * 10 + num;
                if (!seen.contains(key)) {
                    ans++;
                    seen.add(key);
                }
            } else {
                map.put(target - num, num);
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] ints = {1, 1, 2, 45, 46, 46};
        int[] ints1 = {1};
        int[] ints2 = {1, 5, 1, 5};
        System.out.println(getUniquePairsOpti(ints, 47));
        System.out.println(getUniquePairsOpti(ints1, 2));
        System.out.println(getUniquePairsOpti(ints2, 6));
    }
}
