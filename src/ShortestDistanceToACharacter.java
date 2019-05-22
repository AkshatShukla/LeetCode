import java.util.Arrays;

public class ShortestDistanceToACharacter {
    public static int[] shortestToChar(String S, char C) {
        /*
        When going left to right, we'll remember the index prev of the last character C we've seen.
         Then the answer is i - prev.

        When going right to left, we'll remember the index prev of the last character C we've seen.
        Then the answer is prev - i.

        We take the minimum of these two answers to create our final answer.
         */
        int[] result = new int[S.length()];
        int prev = Integer.MIN_VALUE / 2;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                prev = i;
            }
            result[i] = i - prev;
        }

        prev = Integer.MAX_VALUE / 2;

        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i)  == C) {
                prev = i;
            }
            result[i] = Math.min(result[i], prev - i);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(shortestToChar("loveleetcode", 'e'))); // [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
    }
}
