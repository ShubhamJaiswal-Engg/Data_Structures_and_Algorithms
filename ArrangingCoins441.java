
// 441. Arranging Coins

// Brute Force Approach

class ArrangingCoins441 {
    public int arrangeCoins(int n) {
        long lo = 0, hi = n;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long coinsUsed = mid * (mid + 1) / 2;
            if (coinsUsed <= n) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return (int) hi;
    }
}

// Optimal Approach

class ArrangingCoins441 {
    public int arrangeCoins(int n) {
        /* k (k + 1) \ 2 */
        return (int) (Math.sqrt((2 * n) - 0.25) - 0.5);
    }
}
