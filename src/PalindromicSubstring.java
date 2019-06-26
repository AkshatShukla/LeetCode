public class PalindromicSubstring {
    public static int countSubstrings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int N = s.length();
        boolean[][] dp = new boolean[N + 1][N + 1];

        int count = N;
        for (int j = 1; j < N; j++) {
            for (int i = 0; i < j; i++) {
                boolean isInnerPalindrome = dp[i + 1][j - 1] || j - i <= 2;

                if (isInnerPalindrome && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("abc")); // 3
        System.out.println(countSubstrings("aaa")); // 6
    }
}
