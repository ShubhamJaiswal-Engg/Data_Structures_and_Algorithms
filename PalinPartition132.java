
// 132. Palindrome Partitioning II

class PalinPartition132 {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] pal = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || pal[i + 1][j - 1])) {
                    pal[i][j] = true;
                }
            }
        }

        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int mini = Integer.MAX_VALUE;
            for (int k = i; k < n; k++) {
                if (pal[i][k]) {
                    mini = Math.min(mini, 1 + dp[k + 1]);
                }
            }
            dp[i] = mini;
        }
        return dp[0] - 1;
    }
}