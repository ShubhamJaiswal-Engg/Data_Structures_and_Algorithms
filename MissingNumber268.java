// 268. Missing Number

class MissingNumber268 {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int calculateLen = 0;
        int totalLen = (int) (len * ( len + 1)) / 2;
        for(int i = 0; i < len; i++) {
            calculateLen += nums[i];
        }
        return totalLen - calculateLen;
    }
}
