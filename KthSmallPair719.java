
// 719. Find K-th Smallest Pair Distance

class KthSmallPair719 {
    private int countPair(int[] nums, int distance) {
        int left = 0;
        int count = 0;
        for(int right = 1; right < nums.length; right++) {
            while((nums[right] - nums[left]) > distance) left++;
            count += right - left;
        }
        return count;
    }

    public int smallestDistancePair(int[] nums, int k) {

        Arrays.sort(nums);
        
        int n = nums.length;
        int low = 0;
        int high = nums[n - 1] - nums[0];
        int ans = -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(countPair(nums, mid) >= k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}