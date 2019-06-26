import java.util.Arrays;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1]; // dp[i] is min num of denomination needed for amount i;
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static int coinChangeOptimization(int[] coins, int amount) {
        Arrays.sort(coins); // sort coins in O(nlogn)
        int max = amount + 1;
        int[] dp = new int[amount + 1]; // dp[i] is min num of denomination needed for amount i;
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                } else {
                    // no need to go over coins bigger than the amount
                    break;
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2,5}, 11));
        System.out.println(coinChangeOptimization(new int[]{1,2,5}, 11));
    }
}
