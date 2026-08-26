
// 209. Minimum Size Subarray Sum

class  MinimumSizeSubArray209 {
    public int minSubArrayLen(int target, int[] nums) {
   
        int min = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        // Two Pointer approach with sliding window
        for(int right = 0; right < nums.length; right++) {
            sum = sum + nums[right];

            while(sum >= target) {
                sum -= nums[left];
                min = Math.min(min, right - left + 1);
                left++;
            };
        };
        return min = min == Integer.MAX_VALUE ? 0 : min;
    };
};