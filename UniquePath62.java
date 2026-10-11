
// 62. Unique Paths

// Recursion approach O(M * N )
class UniquePath62 {
    private int countPath(int i, int j, int m, int n, int[][] memo) {
        if(i >= m || j >= n) return 0;
        if(i == m - 1 && j == n - 1) return 1;

        if(memo[i][j] != -1) {
            return memo[i][j];
        }

        return memo[i][j] = countPath(i + 1, j, m, n, memo) +  countPath(i, j + 1, m, n, memo);
    }

    public int uniquePaths(int m, int n) {
        int [][] memo = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        
        return countPath(0, 0, m, n, memo);
    }
}

// DP Approach
class UniquePath62 {
    public int uniquePaths(int m, int n) {

        int[] dp = new int[m];
        dp[m - 1] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
              if (j + 1 < m) {
                    dp[j] += dp[j + 1];   // dp[j] already holds the from below value
                }
            }
        }
        return dp[0];
    }
}