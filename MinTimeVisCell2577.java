
// 2577. Minimum Time to Visit a Cell In a Grid

class MinTimeVisCell2577 {
    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) return -1;
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, 0, 0});

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int arrivalTime = curr[0];
            int x = curr[1];
            int y = curr[2];

            if (vis[x][y]) continue;
            vis[x][y] = true;

            if (x == m - 1 && y == n - 1) return arrivalTime;

            for (int l = 0; l < 4; l++) {
                int nx = x + dx[l];
                int ny = y + dy[l];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !vis[nx][ny]) {
                    int remaining = Math.max(0, grid[nx][ny] - arrivalTime);
                    int nextTime;
                    if (remaining == 0) nextTime = arrivalTime + 1;
                    else if (remaining % 2 == 1) nextTime = grid[nx][ny];
                    else nextTime = grid[nx][ny] + 1;
                    pq.offer(new int[]{nextTime, nx, ny});
                }
            }
        }
        return -1;
    }
}