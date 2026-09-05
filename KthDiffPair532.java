
// 532. K-diff Pairs in an Array

class KthDiffPair532 {
    public int findPairs(int[] nums, int k) {
        if(k < 0) return 0;

        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int pair = 0;
        for(int num : freq.keySet()) {
            if(k == 0) {
                // If k = 0  then it need duplicate number to provide pair
                if(freq.get(num) > 1) {
                    pair++;
                } 
            } else {
                    // a - b = k then a + k = b
                    if(freq.containsKey(num + k)) {
                        pair++;
                    }
                }
        }

        return pair;
    }
}

