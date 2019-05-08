public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        // Find all ways to reach every cell in the matrix from top left corner
        int[][] dp = new int[m][n];

        // Fill first column with 1 way of reaching each cell, that is going DOWN
        for (int i=0; i<dp.length; i++) {
            dp[i][0] = 1;
        }

        // Fill first row with 1 way of reaching each cell, that is going RIGHT
        for (int j=0; j<dp[0].length; j++) {
            dp[0][j] = 1;
        }

        for (int i=1; i<dp.length; i++) {
            for (int j=1; j<dp[i].length; j++) {
                // ways to reach current cell dp[i][j] is from top or left
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3,2));
        /*
        From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
        1. Right -> Right -> Down
        2. Right -> Down -> Right
        3. Down -> Right -> Right
         */
        System.out.println(uniquePaths(7, 3)); // 28
    }
}
