
// 50. Pow(x, n)
// T.C - O(log n)

class Pow50 {
    public double myPow(double x, int n) {

        return n < 0 ? 1 / fastPow(x, -n) : fastPow(x, n);
    }
    
    private double fastPow(double x, int n) {
        if (n == 0) return 1.0;
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}




// Easy using Math
class Pow50 {
    public double myPow(double x, int n) {
        return Math.pow(x, n);
    };
};