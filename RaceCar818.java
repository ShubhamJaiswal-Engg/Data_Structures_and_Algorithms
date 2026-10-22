
// 818. Race Car

class RaceCar818 {
    public int racecar(int target) {
        int[] dp = new int[target + 1];
        int n = 1;
        for (int i = 1; i <= target; i++) {
            if (i == (1 << n) - 1) {   //  (a << b)  means a * 2 ^ b         
                dp[i] = n;
                n++;
            } else {
                dp[i] = Integer.MAX_VALUE;
                // target se aage chle gye abb pich aao
                for (int j = 0; j < n - 1; j++) {   
                    dp[i] = Math.min(dp[i],
                    // remaining distance get from dp
                        n + j + 1 + dp[i - (1 << (n - 1)) + (1 << j)]);
                }
                // pahle ruko aur check kro 
                dp[i] = Math.min(dp[i], n + 1 + dp[(1 << n) - 1 - i]);
            }
        }
        return dp[target];
    }
}