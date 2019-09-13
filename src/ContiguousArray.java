import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public static int findMaxLength(int[] nums) {
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>(); // index, count
        map.put(0, -1);
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            count += (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count))
                maxLen = Math.max(maxLen, i - map.get(count));
            else
                map.put(count, i);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{0,1,0}));
        System.out.println(findMaxLength(new int[]{0,1}));
        System.out.println(findMaxLength(new int[]{0,0,1,1}));
    }
}
