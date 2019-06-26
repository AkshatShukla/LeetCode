import java.util.Arrays;

public class LongestPalindromicSubsequence {
    public static int longestPalindromeSubseq(String s) {
        int N = s.length();
        int[][] dp = new int[N][N];

        // L = 1 // 1 char at a time
        for (int i = 0; i < N; i++) {
            dp[i][i] = 1;
        }

        for (int l = 2; l <= N; l++) {
            for (int i = 0; i < N - l + 1; i++) {
                int j = i + l - 1;
                // for length 2
                boolean isCharSame = s.charAt(i) == s.charAt(j);
                if (l == 2 && isCharSame) {
                    dp[i][j] = 2;
                } else if (isCharSame) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));

        return dp[0][N - 1];
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("agbdba"));
    }
}
