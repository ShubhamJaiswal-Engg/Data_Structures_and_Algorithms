
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

//Binary Search approach

class ArrangingCoins441 {
    public int arrangeCoins(int n) {
        long low = 0, high = n;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (mid * (mid + 1) / 2 <= n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (int) high;
    }
}

// Optimal Approach

class ArrangingCoins441 {
    public int arrangeCoins(int n) {

        /* k (k + 1) \ 2
        Only 2 will overflow for long array using 2.0 (double) which handle
        large number then cast into int */ 
        
        return (int) (Math.sqrt((2.0 * n) - 0.25) - 0.5);
    }
}
