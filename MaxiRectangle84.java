
// 85. Maximal Rectangle

class MaxiRectangle84 {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[] = new int[n];
        int ans = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++)  {
                if(matrix[i][j] == '1') dp[j] = dp[j] + 1;
                else if(matrix[i][j] == '0') dp[j] = 0;
            }
            ans = Math.max(ans, largestRectangleArea(dp));
        }
    return ans;
    }
    private int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] minLeft = new int[n];
        int[] rightMin = new int[n];

        minLeft[0] = -1;
        rightMin[n - 1] = n;
        // left min
        for(int right = 0; right < n; right++) {
            int left = right - 1;
            while(left >= 0) {
                if(heights[left] >= heights[right]) {
                    left = minLeft[left];
                } else {
                    break;
                }
            }
            minLeft[right] = left;
        }
        // right min
        for(int left = n - 2; left >= 0; left--) {
            int right = left + 1;
            while(right < n) {
                if(heights[right] >= heights[left]) {
                    right = rightMin[right];
                } else {
                    break;
                }
            }
            rightMin[left] = right;
        }
        int ans = 0;
        for(int i = 0; i < n; i++) {
            // - 1 for total bar
            int max = (rightMin[i] - minLeft[i] - 1) * (heights[i]);
            ans = Math.max(max, ans);
        }
        return ans;
    }
}