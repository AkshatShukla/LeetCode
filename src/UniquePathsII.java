public class UniquePathsII {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        // first col, only way is to go down
        for (int i = 0; i < dp.length; i++) {
            if (obstacleGrid[i][0] != 1)
                dp[i][0] = 1;
            else
                dp[i][0] = 0;
        }

        // first row, only way is to go right
        for (int j = 0; j < dp[0].length; j++) {
            if (obstacleGrid[0][j] != 1)
                dp[0][j] = 1;
            else
                dp[0][j] = 0;
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (obstacleGrid[i][j] != 1) {
                    if (j > 0 && i > 0) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    } else if (i > 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else if (j > 0) {
                        dp[i][j] = dp[i][j - 1];
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] matrix1 = {{1, 0}};
        System.out.println(uniquePathsWithObstacles(matrix));
        System.out.println(uniquePathsWithObstacles(matrix1));
    }
}
