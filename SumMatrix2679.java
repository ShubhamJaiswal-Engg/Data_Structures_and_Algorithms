
// 2679. Sum in a Matrix

class SumMatrix2679 {
    public int matrixSum(int[][] nums) {
        
        int m = nums.length;
        int n = nums[0].length;
        for(int[] num : nums) {
            Arrays.sort(num);
        };
        int ans = 0;
        for(int j = 0; j < n; j++) {
            int maxVal = 0;
            for(int i = m - 1; i >= 0; i--) {
                maxVal = Math.max(maxVal, nums[i][j]);
            }
            ans += maxVal;
        }
        return ans;
    }
}