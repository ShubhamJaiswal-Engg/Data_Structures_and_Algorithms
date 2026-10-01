
// 2553. Separate the Digits in an Array

class SeparateDigitArray2553 {
    public int[] separateDigits(int[] nums) {
       int total = 0;

       for(int i = 0; i < nums.length; i++) {
          for(int j = nums[i]; j > 0; j /= 10) total++;
       }
       
       // Insert from end to end as modules do (%)
       int ans[] = new int[total];
       int idx = total - 1;
       for(int j = nums.length - 1; j >=0; j--) {
        for(int i = nums[j]; i > 0; i /= 10) {
        ans[idx--] = i % 10;
       }
      }
      return ans;
    }
}