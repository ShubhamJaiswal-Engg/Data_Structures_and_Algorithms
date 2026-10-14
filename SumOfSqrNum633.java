
// 633. Sum of Square Numbers

class SumOfSqrNum633 {
    public boolean judgeSquareSum(int c) {

        // two pointer approach
        long left = 0;
        // long right = c;
        long right = (long) Math.sqrt(c);
        while(left <= right) {
            long sum = left * left + right * right;
            if(sum == c) {
                return true;
            }else if(sum > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }
}