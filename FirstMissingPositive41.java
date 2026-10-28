
// 41. First Missing Positive

class FirstMissingPositive41 {

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < nums.length; i++) {
            while(nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1); // nums[i] - 1 is j here
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] - 1 != i) {
                return i + 1;
            }
        }
        return n + 1;
    }
}