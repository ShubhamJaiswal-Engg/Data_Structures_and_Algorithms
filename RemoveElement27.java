
// 27. Remove Element
// Approach First

class RemoveElement27 {
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

// Approach Second

class RemoveElement27 {
    public int removeElement(int[] nums, int val) {
        int i=0;
        for(int j=0;j<nums.length;j++)
        {
            if(nums[j]!=val)
            {
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
            }
        }
        return i;
    }
}