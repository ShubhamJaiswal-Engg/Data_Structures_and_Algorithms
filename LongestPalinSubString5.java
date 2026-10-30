
// 5. Longest Palindromic Substring

class LongestPalinSubString5 {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] pal = new boolean[n][n];
         for (int left = n - 1; left >= 0; left--) {
            for (int right = left; right < n; right++) {
                if (s.charAt(left) == s.charAt(right) && (right - left < 2 || pal[left + 1][right - 1])) {
                    pal[left][right] = true;
                }
            }
        }
        String result = "";
        int max = -1;
        for (int i = 0; i < n; i++) {
            for (int k = i; k < n; k++) {
                if (pal[i][k] && k - i > max) {
                    result = s.substring(i, k + 1);
                    max = k - i;
                }
            }
        }
        return result;
    }
}

class LongestPalinSubString5 {
public String longestPalindrome(String s) {
    int n = s.length();
    boolean[][] pal = new boolean[n][n];
    int start = 0, maxLen = 1;

    for (int left = n - 1; left >= 0; left--) {
        for (int right = left; right < n; right++) {
            if (s.charAt(left) == s.charAt(right)
                    && (right - left < 2 || pal[left + 1][right - 1])) {
                pal[left][right] = true;
                if (right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                    start = left;
                }
            }
        }
    }
    return s.substring(start, start + maxLen);
}
}