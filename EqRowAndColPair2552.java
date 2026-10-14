
// 2352. Equal Row and Column Pairs

class EqRowAndColPair2552 {
    public int equalPairs(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] result = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                // transposing matrix
                result[i][j] = grid[j][i];
             }
        }
        int cnt = 0;
        // check equal Row and Column
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(Arrays.equals(grid[i], result[j])) cnt++;
             }
        }
        return cnt;
    }
}