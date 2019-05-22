import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    public static List<Integer> partitionLabels(String S) {
        Map<Character, Integer> hm = new HashMap<>(); // character and its last occurrence index
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < S.length(); i++) {
            hm.put(S.charAt(i), i);
        }

        int i = 0;
        while (i < S.length()) {
            int end = hm.get(S.charAt(i));
            int j = i;
            while (j != end) {
                end = Math.max(end, hm.get(S.charAt(j)));
                // see for characters in the middle of first and last
                // occurrence of the char at i
                j++;
            }
            result.add(j - i + 1);
            i = j + 1; // start off now excluding the first partition
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }
}
