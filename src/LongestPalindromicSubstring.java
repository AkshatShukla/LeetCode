public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        int N = s.length();

        if (s == null || N < 2) {
            return s;
        }

        boolean[][] dp = new boolean[N + 1][N + 1];

        int left = 0;
        int right = 0;

        for (int j = 1; j < N; j++) {
            for (int i = 0; i < j; i++) {
                // check if inner string is palindrome or not or if that inner string is a single character
                boolean isInnerPalindrome = dp[i + 1][j - 1] || j - i <= 2;

                if (s.charAt(i) == s.charAt(j) && isInnerPalindrome) {
                    dp[i][j] = true;

                    // if the current window is greater than previous, update
                    if (j - i > right - left) {
                        left = i;
                        right = j;
                    }
                }
            }
        }

        return s.substring(left, right + 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}
