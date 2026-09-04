
// 724. Find Pivot Index

class FindPivotIndex724 {
    public int pivotIndex(int[] nums) {
        int rightSum = 0;
        // Total sum of array get rightSum
        for(int num : nums) {
            rightSum += num;
        };

        int leftSum = 0;

        // Iterate over array
        for(int i = 0; i < nums.length; i++) {
            int val = nums[i];

            // update rightsum
            rightSum -= val;

            // If both are same then
            if(leftSum == rightSum) {
                return i;
            }

            // Update LeftSum
            leftSum += val;
        }
        // If does not get index then 
        return -1;
    }
}