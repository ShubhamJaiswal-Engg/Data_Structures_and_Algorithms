
// 326. Power of Three

boolean isPowerOfThree(int n) {
    if (n < 1) return false;
    while (n % 3 == 0) n /= 3;
    return n == 1;
}


// sc - O(log n)
class Solution {
    public boolean isPowerOfThree(int n) {
        return (Integer.toString(n , 3).matches("^10*$"));
    }
}
// TC - O(1)
// SC - O(1)
public boolean isPowerOfThree(int n) {
    return n > 0 && 1162261467 % n == 0;
}