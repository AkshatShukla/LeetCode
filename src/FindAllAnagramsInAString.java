import java.util.*;

public class FindAllAnagramsInAString {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }
        int windowSize = p.length();

        for (int i = 0; i < s.length() - windowSize + 1; i++) {
            String currentString = s.substring(i, i + windowSize);
            if (isAnagram(currentString, p)) {
                result.add(i);
            }
        }

        return result;
    }

    public static boolean isAnagram(String a, String b) {
        if (a == null || b == null || a.length() != b.length()) {
            return false;
        }
        int[] dict = new int[26];
        for (int i = 0; i < b.length(); i++) {
            char ch = b.charAt(i);
            dict[ch - 'a']++;
        }

        for (int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);
            dict[ch - 'a']--;
            if (dict[ch - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    public static List<Integer> findAnagramsHash(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        if (p.length() > s.length()) {
            return result;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int match = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    match++;
                }
            }
            if (i >= p.length()) {
                c = s.charAt(i - p.length());
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                    if (map.get(c) == 1) {
                        match--;
                    }
                }
            }
            if (match == map.size()) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagramsHash("cbaebabacd", "abc"));
    }
}
