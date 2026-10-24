
// 44. Wildcard Matching

class WildCardMatch44 {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int j = 1; j <= n; j++)
            dp[0][j] = dp[0][j - 1] && p.charAt(j - 1) == '*';

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char pc = p.charAt(j - 1);
                if (pc == '*')
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                else if (pc == '?' || pc == s.charAt(i - 1))
                    dp[i][j] = dp[i - 1][j - 1];
            }
        }
        return dp[m][n];
    }
}

// tc -> O(2^(m + n))  S.C -> O(n ^ 2)
class WildCardMatch44 {
    public boolean isMatch(String s, String p) {
        return helpIsMatch(s, p, s.length() - 1, p.length() - 1);
    }

    private boolean helpIsMatch(String s, String p, int i, int j) {
        if(i < 0 && j < 0) {
            return true;
        }
        if(i >= 0 && j < 0) {
            return false;
        }
        if(i < 0 && j >= 0) {
            for(int k = 0; k <= j; j++) {
                if(p.charAt(k) != '*') {
                    return false;
                }
            }
            return true;
        }
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            return helpIsMatch(s, p, i - 1, j - 1);
        } else if(p.charAt(j) == '*') {
            return helpIsMatch(s, p, i - 1, j) || helpIsMatch(s, p, i, j - 1);
        } else {
            return false;
        }
    }
}

// tc -> O(m + n) S.C -> O(n)

class WildCardMatch44 {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        // boolean[][] dp = new boolean[m + 1][n + 1];
        boolean[] prev = new boolean[n + 1];
        boolean[] curr = new boolean[n + 1];
        prev[0] = true;

        for (int j = 1; j <= n; j++)
            prev[j] = prev[j - 1] && p.charAt(j - 1) == '*';

        for (int i = 1; i <= m; i++) {
            curr[0] = false;                       
            for (int j = 1; j <= n; j++) {
                curr[0] = false;
                char pc = p.charAt(j - 1);
                if (pc == '*')
                    curr[j] = prev[j] || curr[j - 1];
                else if (pc == '?' || pc == s.charAt(i - 1))
                    curr[j] = prev[j - 1];
                else
                    curr[j] = false; // this will run without this               
            }

            // swap prev to curr
            boolean[] tmp = prev;                 
            prev = curr;
            curr = tmp;
        }
        return prev[n];
    }
}