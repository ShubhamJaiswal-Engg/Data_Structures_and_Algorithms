
// 441. Arranging Coins

class ArrangingCoins441 {
    public int arrangeCoins(int n) {
        return (int) (Math.sqrt((2 * n) - 0.25) - 0.5);
    }
}