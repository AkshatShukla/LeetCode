import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,2,3,3,1};
        Set<Integer> set = new HashSet<>();
        int singleNum = 0;
        for (int n:nums) {
            if (set.contains(n)) {
                set.remove(n);
            } else {
                set.add(n);
            }
        }
        singleNum = (int) set.toArray()[0];
        System.out.println(singleNum);
    }
}
