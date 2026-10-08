
// 15. 3Sum

class 3Sum15.java {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < n; i++) {
            int j = i+1, k = n - 1;
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if(sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ans.add(list);
                    j++;
                    k--;

                    while(j < k && nums[j - 1] == nums[j]) j++;
                }
            }
        }
        return ans;
    }
}