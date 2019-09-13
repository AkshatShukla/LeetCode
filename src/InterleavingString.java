public class InterleavingString {
    public static boolean isInterleave(String s1, String s2, String s3) {
        // dynamic programming
        // 2d matrix of size s1.length()+1 * s2.length()+1
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        if (s1.length() + s2.length() != s3.length())
            return false;

        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        char[] str3 = s3.toCharArray();

        //   0 a a b
        // 0 T T T F
        // a T
        // x F
        // y F

        // s3: aaxaby
        //      ^
        // if (s1.charAt(i) == s3.charAt(i)) dp[0][i] = dp[0][i - 1];
        // if (s2.charAt(j) == s3.charAt(j)) dp[j][0] = dp[j - 1][0];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                int l = i + j - 1;
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    if (str3[l] == str2[j - 1]) {
                        dp[i][j] = dp[i][j - 1];
                    }
                } else if (j == 0) {
                    if (str3[l] == str1[i - 1]) {
                        dp[i][j] = dp[i - 1][j];
                    }
                } else {
                    dp[i][j] = (str1[i - 1] == str3[l] ? dp[i - 1][j] : false) || (str2[j - 1] == str3[l] ? dp[i][j - 1] : false);
                }

            }
        }

        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca","aadbbcbcac"));
        System.out.println(isInterleave("aab","axy","aaxaby"));
        System.out.println(isInterleave("aab","axy","abaaxy"));
    }
}
