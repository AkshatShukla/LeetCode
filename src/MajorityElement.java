import java.util.HashMap;

public class MajorityElement {
    public static void main(String[] args) {
//        int[] nums = new int[]{3,2,3};
        int [] nums = new int[]{2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }

    private static int majorityElement(int[] nums) {
        int count = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int n:nums) {
            if (hashMap.containsKey(n)) {
                count = hashMap.get(n);
                hashMap.put(n, count + 1);
            } else
                hashMap.put(n, 1);
        }
        for (int k:hashMap.keySet()) {
            if (hashMap.get(k)>nums.length/2)
                return k;
        }
        return 0;
    }
}
