import java.util.*;

public class MinimumWindowSubstring {
    /*
     Sliding Window: Use 2 Pointers To Compose A Sliding Window
    */
    public static String minWindow(String s, String t) {
        // The characters a satisfiable window must cover mapped to their frequency
        Map<Character, Integer> requiredCharsMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            requiredCharsMap.put(c, requiredCharsMap.getOrDefault(c, 0) + 1);
        }

        /*
        For our window. Map all characters in the window to their occurrence count. You
        will see how we use this below.
        */
        Map<Character, Integer> windowCharacterMap = new HashMap<>();

        /*
        2 pointers. Left holds the left index of the window we are inspecting and right
        holds the right index.
        The approach is simple. We keep moving right (don't touch left) until the window
        we hold satisfies all required characters. Then we take note whether the window
        we see beats the smallest satisfiable window we have found so far.
        We then contract the left pointer in while the window still satisfies all required
        characters (at every point continuing to check if we have beaten the smallest window
        ever seen to this point)
        As soon as the window no longer satisfies, go back to expanding the right pointer.
        We are finished when the right pointer runs over the array because we can't keep
        expanding the window to satisfy at that point.
        */
        int left = 0;
        int right = 0;

        /*
        'totalCharFrequenciesToMatch' is the total characters we need to match frequency for
        in the window. If I have 1 'a' in my window and I need 2 'a' chars...then the char
        frequencies don't match.
        'charFrequenciesInWindowThatMatch' is the count of frequencies that we have satisfied.
        When 'totalCharFrequenciesToMatch' == 'charFrequenciesInWindowThatMatch' then it can be
        said that the current window satisfies that property of having all characters with matching
        counts to the string t.
         */
        int totalCharFrequenciesToMatch = requiredCharsMap.size();
        int charFrequenciesInWindowThatMatch = 0;

        int minLeft = 0;
        int minRight = 0;
        /*
        We will keep track of the best window we have seen so far
        */
        int minWindowLengthSeenSoFar = Integer.MAX_VALUE;

        // if window does not satisfy, expand window and move right outwards
        // if window does satisfy, contract window and move left inwards
        while (right < s.length()) {
            char charAtRight = s.charAt(right);

            /*
            Add the character on the right pointer to the hashtable that maps the characters seen
            in the window to their occurrence count
            */
            windowCharacterMap.put(charAtRight, windowCharacterMap.getOrDefault(charAtRight, 0) + 1);

            /*
            Is this character part of the requirement?
            */
            boolean charAtRightSatisfies = requiredCharsMap.containsKey(charAtRight);

            // check if the right char is present in the required char map
            if (charAtRightSatisfies) {
                int requiredRightCharFrequency = requiredCharsMap.get(charAtRight);
                int seenRightCharFrequency = windowCharacterMap.get(charAtRight);
                boolean requirementForCharMet = requiredRightCharFrequency == seenRightCharFrequency;
                /*
                 Does the current window frequency match the required frequency?
                */
                if (requirementForCharMet) {
                    /*
                    If so then we have one more frequency requirement that matches...remember when:
                    'totalCharFrequenciesToMatch' == 'charFrequenciesInWindowThatMatch' then we know that
                    we have a satisfying window
                    */
                    charFrequenciesInWindowThatMatch++;
                }
            }

            /*
            Does this window satisfy? Ok...if it does try contracting the left pointer inward until
            we go over the right pointer.
            */
            while (charFrequenciesInWindowThatMatch == totalCharFrequenciesToMatch && left <= right) {
                char charAtLeft = s.charAt(left);
                int currentWindowSize = right - left + 1;

                /*
                Have we beat the best satisfiable window seen so far? Ok...if so then update
                the tracking variables
                 */
                if (currentWindowSize < minWindowLengthSeenSoFar) {
                    minWindowLengthSeenSoFar = currentWindowSize;
                    minLeft = left;
                    minRight = right + 1;
                }

                /*
                This character will get contracted out. It won't be in the window anymore once
                left moves forward.
                */
                windowCharacterMap.put(charAtLeft, windowCharacterMap.get(charAtLeft) - 1);

                /*
                Was this character part of the requirement? If so then its frequency changing matters to us.
                 */
                boolean charAtLeftSatisfies = requiredCharsMap.containsKey(charAtLeft);
                if (charAtLeftSatisfies) {
                    int requiredLeftCharFrequency = requiredCharsMap.get(charAtLeft);
                    int seenLeftCharFrequency = windowCharacterMap.get(charAtLeft);
                    boolean requirementForCharNotMet = requiredLeftCharFrequency > seenLeftCharFrequency;
                    if (requirementForCharNotMet) {
                        /*
                        If so then we have one less character frequency mapping in the window that matches
                        */
                        charFrequenciesInWindowThatMatch--;
                    }
                }

                /*
                Move the left point forward. We will keep going until the window no longer satisfies.
                */
                left++;
            }

            /*
            We have moved left as far as it could go. It either led to a window that no longer
            satisfied or left passed the right pointer. Either way...advance the right pointer.
            */
            right++;
        }

        return s.substring(minLeft, minRight);
    }


    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a", "aa"));
        System.out.println(minWindow("aa", "aa"));
    }
}
