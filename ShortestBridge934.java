
// 934. Shortest Bridge

class ShortestBridge934 {
    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        Queue<int[]> queue = new ArrayDeque<>();

        //find first island, mark it as 2, collect its island cells
        boolean breakFlag = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, queue);
                    breakFlag = true;
                    break;
                }
            }
            if(breakFlag == true) {
                break;
            }
        }

        //multi-source BFS expanding over water until we hit the other island
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] cur = queue.poll();
                for (int[] d : DIRS) {
                    int r = cur[0] + d[0];
                    int c = cur[1] + d[1];
                    if (r < 0 || c < 0 || r >= n || c >= n || grid[r][c] == 2) continue;
                    if (grid[r][c] == 1) return steps;
                    grid[r][c] = 2; // mark water as visited
                    queue.offer(new int[]{r, c});
                }
            }
            steps++;
        }
        return -1;
    }

    private void dfs(int[][] grid, int r, int c, Queue<int[]> queue) {
        int n = grid.length;
        if (r < 0 || c < 0 || r >= n || c >= n || grid[r][c] != 1) return;
        grid[r][c] = 2;
        queue.offer(new int[]{r, c});
        for (int[] d : DIRS) {
            dfs(grid, r + d[0], c + d[1], queue);
        }
    }
}