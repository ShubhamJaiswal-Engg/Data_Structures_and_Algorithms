
// 63. Unique Paths II

// Recursion Stack approach
class UniquePathII63 {
    private int uniqueII(int i, int j,int[][] obstacleGrid, int[][] memo) {
        if(i >= obstacleGrid.length || j >= obstacleGrid[0].length || obstacleGrid[i][j] == 1) return 0;

        if(i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1) return 1;
        // memoization
        if(memo[i][j] != -1) {
            return memo[i][j];
        }

        return memo[i][j] = uniqueII(i + 1, j, obstacleGrid,memo) + uniqueII(i, j + 1, obstacleGrid,memo);

    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int [][] memo = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return uniqueII(0, 0, obstacleGrid, memo);
    }
}

// Using Dynamic Programming approach
class UniquePathII63 {
    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] dp = new int[m];
        dp[m - 1] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if(grid[i][j] == 1) {
                    dp[i][j] = 0;
                } else if (j + 1 < m) {
                    dp[j] += dp[j + 1];   // dp[j] already holds the "from below" value
                }
            }
        }
        return dp[0];
    }
}