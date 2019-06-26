import java.util.HashSet;
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

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }
}
