import java.util.HashMap;
import java.util.Map;

public class PairsofSongsWithTotalDurationsDivisibleby60 {
    public static int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int t : time) {
            int x = (60 - t % 60) % 60;
            if (map.containsKey(x)) {
                count += map.get(x);
            }
            map.put(t % 60, map.getOrDefault(t % 60, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40}));
        System.out.println(numPairsDivisibleBy60(new int[]{60, 60, 60}));
    }
}
