
// 1639. Number of Ways to Form a Target String Given a Dictionary

class WayToFormTarStr1639 {
    public int numWays(String[] words, String target) {
        final int mod = 1_000_000_007;
        int m = target.length();
        int colSize = words[0].length();

        int[][] occur = new int[26][colSize];
        for (String str : words) {
            for (int i = 0; i < colSize; i++) {
                occur[str.charAt(i) - 'a'][i]++;
            }
        }

        // dp[i][j] = ways to form target[0..i) using the first j columns
        long[][] dp = new long[m + 1][colSize + 1];
        for (int j = 0; j <= colSize; j++) {
            dp[0][j] = 1; // empty target -> exactly one way
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= colSize; j++) {
                // exclude column j-1
                dp[i][j] = dp[i][j - 1];
                // include column j-1
                dp[i][j] = (dp[i][j]
                        + (long) occur[target.charAt(i - 1) - 'a'][j - 1] * dp[i - 1][j - 1]) % mod;
            }
        }

        return (int) dp[m][colSize];
    }
}