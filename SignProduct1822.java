

// 1822. Sign of the Product of an Array

// Brute force approach 
class SignProduct1822 {
    public int arraySign(int[] nums) {
        int totSum = 1;
        for(int i = 0; i < nums.length; i++) {
            totSum *= nums[i];
        }
        if(totSum == 0) {
            return 0;
        } else if (totSum > 0) {
            return 1;
        } else {
            return -1;
        }
    }
}

// Optimized Solution 

class SignProduct1822 {
    public int arraySign(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) return 0;
            if(nums[i] < 0) {
                count++;
            };
        };
        if(count % 2 == 1) {
            return -1;
        }else {
            return 1;
        };
    };
