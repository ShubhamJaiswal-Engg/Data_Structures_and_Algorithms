
// 128. Longest Consecutive Sequence

class LongConsecutiveSeq128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums) {
            set.add(num);
        }
        int ansCount = 0;
        
        // Ignore Duplicate by set (TLE)
        for(int i : set) {
            int count = 1;
            if(!set.contains(i - 1)) {
                int num = i;
                while(set.contains(num + 1)) {
                    count++;
                    num++;
                }
                ansCount = Math.max(count, ansCount);
            }
        }
        return ansCount;
    }
}