
// 2598. Smallest Missing Non-negative Integer After Operations

class SmallMissNonNegIntAfterOpert2598 {
    public int findSmallestInteger(int[] nums, int value) {
        int[] count = new int[value];

        for(int x : nums) {
            // first % can be negative, + value shifts it up, second % handles the non-negative case 
            count[(( x % value) + value) % value]++;
        }

        int ans = 0;
        while(true) {
            int r = ans % value;
            if(count[r] == 0) return ans;
            count[r]--;
            ans++;
        }
    }
}