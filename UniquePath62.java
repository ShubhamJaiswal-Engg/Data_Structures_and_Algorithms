
// 62. Unique Paths

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