
// 27. Remove Element

class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[right] == val) {
                count++;
                right--;
            } else if (nums[left] == val) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                count++;
                left++;
                right--;
            } else {
                left++;
            }
        }
        return nums.length - count;
    }
}