
// 829. Consecutive Numbers Sum

class ConsecutiveNumSum829 {
    public int consecutiveNumbersSum(int n) {

        int k = (int) (Math.sqrt((2 * n + 0.5) - 0.25));
        int cnt = 0;
        for(int i = 1; i <= k; i++) {
            if((n - (i * (i + 1) / 2)) % i == 0) {
                cnt++;
            }
        }
        return cnt;
    }
}