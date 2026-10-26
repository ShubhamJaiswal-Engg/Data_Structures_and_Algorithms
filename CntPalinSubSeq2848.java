
// 2484. Count Palindromic Subsequences

class CntPalinSubSeq2848 {
    public int countPalindromes(String s) {
        int mod = 1_000_000_007;
        int n = s.length();
        int[][][] prefix = new int[n][10][10];
        int[][][] suffix = new int[n][10][10];
        int[] cnts = new int[10];

        for(int i = 0; i < n; i++) {
            int dig = s.charAt(i) - '0';
            if(i >= 1) {
            for(int j = 0; j < 10; j++) {
                for(int k = 0; k < 10; k++) {
                    prefix[i][j][k] = prefix[i - 1][j][k];
                    if(k == dig) {
                        prefix[i][j][k] += cnts[j];
                    }
                }
            }
          }
        cnts[dig]++;
        }
        Arrays.fill(cnts, 0);
        for(int i = n - 1; i >= 0; i--) {
            int dig = s.charAt(i) - '0';
            if(i <= n - 2) {
            for(int j = 0; j < 10; j++) {
                for(int k = 0; k < 10; k++) {
                    suffix[i][j][k] = suffix[i + 1][j][k];
                    if(k == dig) {
                        suffix[i][j][k] += cnts[j];
                    }
                }
            }
          }
        cnts[dig]++;
      }
      long ans = 0;
       for (int i = 2; i < n - 2; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    ans = (ans + (long) prefix[i - 1][j][k] * suffix[i + 1][j][k]) % mod;
                }
            }
        }
        return (int) ans;
    }
}