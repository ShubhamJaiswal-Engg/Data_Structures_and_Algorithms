// 169. Majority Element

import java.util.*;
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            hMap.put(nums[i], hMap.getOrDefault(nums[i], 0) + 1);
        }
        Set<Integer> key = hMap.keySet();
        for(int keyData : key) {
            if(hMap.get(keyData) > (nums.length/2)) {
                return keyData;
            }
        }
        return -1;
    }
}