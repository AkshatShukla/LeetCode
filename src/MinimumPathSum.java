public class MinimumPathSum {
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int[][] dp = new int[grid.length][grid[0].length];
        // dp[i][j]  = smallest sum to get at i,j

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] += grid[i][j];
                // not on first row and first col
                // either come from above us or left of us
                if (i > 0 && j > 0)
                    dp[i][j] += Math.min(dp[i - 1][j], dp[i][j - 1]);
                else if (i > 0)
                    // above
                    dp[i][j] += dp[i - 1][j];
                else if (j > 0)
                    // left
                    dp[i][j] += dp[i][j - 1];
            }
        }

        return dp[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,3,1},
                {1,5,1},
                {4,2,1}};
        System.out.println(minPathSum(grid)); // 7
        // Because the path 1→3→1→1→1 minimizes the sum.
    }
}
