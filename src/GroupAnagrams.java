import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0)
            return new ArrayList<>();
        HashMap<String, List<String>> hm = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars); // O(NKlog(K)) where K is particular string length and N is String array length
            String key = String.valueOf(chars);
            if (!hm.containsKey(key)) {
                hm.put(key, new ArrayList<>());
            }
            hm.get(key).add(s);
        }

        return new ArrayList<>(hm.values());
    }

    public static void main(String[] args) {
        String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(input));
    }
}
