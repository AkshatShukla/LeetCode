import java.util.*;

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        // i refers to the length of string considered, that is 1, 2, 3 up-til the entire given string s is considered.
        for (int i = 1; i < dp.length; i++) {
            // j refers to the index partitioning the current substring into smaller substring s(0,j) and s(j+1,i)
            for (int j = 0; j < i; j++) {
                String curr = s.substring(j, i);
                if (dp[j] && dict.contains(curr)) {
                    dp[i] =  true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> dict = new ArrayList<>();
        dict.add("leet");
        dict.add("code");
        System.out.println(wordBreak(s, dict));
    }
}
