import java.util.Arrays;

public class DecodeWays {
    public static int numDecodings(String s) {
        int[] dp = new int[s.length() + 1]; // number of ways to decode a string of length index
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= s.length(); i++) {
            int oneDigit = Integer.valueOf(s.substring(i - 1, i)); // first digit
            int twoDigits = Integer.valueOf(s.substring(i - 2, i)); // last two digits
            System.out.println(oneDigit);
            System.out.println(twoDigits);
            System.out.println(Arrays.toString(dp));
            if (oneDigit >= 1) {
                dp[i] += dp[i - 1];
            }

            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[s.length()];
    }

    public static int numDecodingsRecursive(String s) {
        // "3" => "c"
        // "12345" => "a" + decode("2345") or "l" + decode("345")
        // num_ways("12345") => decode("2345") + decode("345")
        // "27345" => "b" + decode("7345")
        // num_ways("27345") => decode("7345")
        // "011" => 0
        // base cases=> string empty or string starts with 0
        int[] memo = new int[s.length() + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        return helper(s, s.length(), memo);
    }

    public static int helper(String s, int k, int[] memo) {
        // see at the last k letters of s
        if (k == 0) {
            return 1;
        }
        int startIdx = s.length() - k;

        if (s.charAt(startIdx) == '0'){
            return 0;
        }
        if (memo[k] != Integer.MAX_VALUE) {
            return memo[k];
        }

        int result = helper(s, k - 1, memo);

        if (k >= 2) {
            int twoDigitVal = Integer.parseInt(s.substring(startIdx, startIdx + 2));
            if (twoDigitVal <= 26) {
                result += helper(s, k - 2, memo);
            }
        }
        memo[k] = result;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("226"));
    }
}
