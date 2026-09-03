
// 136. Single Number

class SingleNum136 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            // a ^ 0 = a
            // a ^ a = 0
            ans = ans ^ nums[i];
        }
         return ans;
    }
}