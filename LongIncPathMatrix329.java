
// 329. Longest Increasing Path in a Matrix

class Solution {
        int [][] memo;
        int rows, cols;
        int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

     
    public int longestIncreasingPath(int[][] matrix) {

        rows = matrix.length;
        cols = matrix[0].length;

        memo = new int[rows][cols];
        int ans = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                ans = Math.max(ans, dfs(matrix, i, j));
            }
        }
        return ans;
    }

       private int dfs(int [][] matrix, int i, int j) {
            if(memo[i][j] != 0) {
                return memo[i][j];
            }
            // Best path from this particular position
            int best = 1;
            for(int d[] : dirs) {
                int x = i + d[0];
                int y = j + d[1];

                if(x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[i][j] < matrix[x][y]) {
                    best = Math.max(best, 1 + dfs(matrix, x, y));
                }
            }
            memo[i][j] = best;
            return best;
        }
}