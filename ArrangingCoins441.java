
// 441. Arranging Coins

class ArrangingCoins441 {
    public int arrangeCoins(int n) {
        /* k (k + 1) \ 2 */
        return (int) (Math.sqrt((2 * n) - 0.25) - 0.5);
    }
}