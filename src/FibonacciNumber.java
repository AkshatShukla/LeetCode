public class FibonacciNumber {
    public static int fibRecursive(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        return fibRecursive(N - 1) + fibRecursive(N - 2);
    }

    public static int fibIterative(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[N];
    }

    public static void main(String[] args) {
        System.out.println(fibRecursive(4));
        System.out.println(fibIterative(4));
        System.out.println(fibIterative(0));
        System.out.println(fibIterative(1));
    }
}
