
// 994. Rotting Oranges

class RottingOrange994 {

    public void dfs(int i, int j, int[][] time, int[][] grid , int currentTime) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || time[i][j] <= currentTime || grid[i][j] == 0) return;

        time[i][j] = currentTime;

        // Call depth-first-search

        dfs(i - 1, j, time, grid, currentTime + 1);
        dfs(i, j - 1, time, grid, currentTime + 1);
        dfs(i + 1, j, time, grid, currentTime + 1);
        dfs(i , j + 1, time, grid, currentTime + 1);
    }

    public int orangesRotting(int[][] grid) {
    
    if(grid == null || grid.length == 0) return 0;
    
    int rows = grid.length;
    int cols = grid[0].length;
    
    // Time array
    int[][] time = new int[rows][cols];
    for(int i = 0; i < grid.length; i++) 
    Arrays.fill(time[i], Integer.MAX_VALUE);

    for(int i = 0; i < rows; i++) {
        for(int j = 0; j < cols; j++) {
            if(grid[i][j] == 2){

                // Bellmon ford
                dfs(i, j, time, grid, 0);
            }
        }
      }
      int timeRequired = 0;
      for(int i = 0; i < rows; i++) {
        for(int j = 0; j < cols; j++) {

            if(grid[i][j] != 0 && time[i][j] == Integer.MAX_VALUE) return -1;
            if(grid[i][j] != 0) timeRequired = Math.max(timeRequired, time[i][j]);
        }
      }
      return timeRequired;
    }
}