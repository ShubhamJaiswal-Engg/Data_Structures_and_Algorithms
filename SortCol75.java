
// 75. Sort Colors

class SortCol75 {
    public void sortColors(int[] nums) {
        int left = 0;
        int mid = 0;
        int right = nums.length - 1;

        // Dutch National Flag algorithm (Three pointer)
        while(mid <= right) {
            switch(nums[mid]) {
                case 0 :
                swap(nums, left, mid);
                left++;
                mid++;
                break;

                case 1 :
                mid++;
                break;

                case 2:
                swap(nums, mid, right);
                right--;
                break;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        // swap
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}