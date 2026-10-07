
// 1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance

class FindCity1334 {
    private void floydWarshall(int[][] d) {
        int n = d.length;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (d[i][k] == Integer.MAX_VALUE) continue;
                for (int j = 0; j < n; j++) {
                    if (d[k][j] == Integer.MAX_VALUE) continue;
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] d = new int[n][n];
        for (int[] row : d) Arrays.fill(row, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) d[i][i] = 0;

        for (int[] e : edges) {
            d[e[0]][e[1]] = e[2];
            d[e[1]][e[0]] = e[2];
        }

        floydWarshall(d);

        int ans = -1, minCount = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(d[i][j] <= distanceThreshold) count++;
            }
            if(count <= minCount) { 
                minCount = count;
                ans = i;
            }
        }
        return ans;
    }
}