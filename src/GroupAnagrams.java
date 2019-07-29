import java.util.*;

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

    public static List<List<String>> groupAnagramsNaive(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Set<String> grouped = new HashSet<>();

         for (int i = 0; i < strs.length; i++) {
             if (!grouped.contains(strs[i])) {
                 List<String> temp = new ArrayList<>();
                 grouped.add(strs[i]);
                 temp.add(strs[i]);
                 for (int j = i + 1; j < strs.length; j++) {
                     if (areAnagrams(strs[i], strs[j])) {
                         grouped.add(strs[j]);
                         temp.add(strs[j]);
                     }
                 }
                 ans.add(temp);
             }
         }

        return ans;
    }

    public static boolean areAnagrams(String s1, String s2) {
        int[] s1Chars = new int[26];
        int[] s2Chars = new int[26];

        for (char c : s1.toCharArray()) {
            s1Chars[c - 'a']++;
        }

        for (char c : s2.toCharArray()) {
            s2Chars[c - 'a']++;
        }

        for (int i = 0; i < s1Chars.length; i++) {
            if (s1Chars[i] != s2Chars[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(input));
        System.out.println(groupAnagramsNaive(input));
    }
}
