
// 1. Two Sum

class TwoSum1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> exist = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if(exist.containsKey(diff)) {
                return new int[]{exist.get(diff), i};
            }

            exist.put(nums[i], i);
        }
        return new int[]{};
    }
}