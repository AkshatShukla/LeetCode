import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubtringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int longest = Integer.MIN_VALUE;
        Set<Character> seen = new HashSet<>();

        while (right < s.length()) {
            char currChar = s.charAt(right);
            if (!seen.contains(currChar)) {
                seen.add(currChar);
                right++;
                longest = Math.max(longest, right - left);
            } else {
                // repeating character
                seen.remove(s.charAt(left));
                left++;
            }
        }
        return longest;
    }

    public static int lengthOfLongestSubstringOptimised(String s) {
        int left = 0;
        int right = 0;
        int longest = Integer.MIN_VALUE;
        Map<Character, Integer> charIdxMap = new HashMap<>();

        while (right < s.length()) {
            char currChar = s.charAt(right);
            if (charIdxMap.containsKey(currChar)) {
                left = Math.max(left, charIdxMap.get(currChar));
            }
            longest = Math.max(longest, right - left + 1);
            charIdxMap.put(currChar, right + 1);
            right++;
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringOptimised("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstringOptimised("bbbbb")); // 1
        System.out.println(lengthOfLongestSubstringOptimised("pwwkew")); // 3
        System.out.println(lengthOfLongestSubstringOptimised("dvdf")); // 3
    }
}
