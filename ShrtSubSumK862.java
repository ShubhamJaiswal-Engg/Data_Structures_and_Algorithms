
// 862. Shortest Subarray with Sum at Least K

class ShrtSubSumK862 {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n + 1];

        for(int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        Deque<Integer> dq = new LinkedList<>();
        int ans = n + 1; // maximum value
        for(int y = 0; y < prefix.length; y++) {
            while(!dq.isEmpty() && prefix[y] <= prefix[dq.getLast()]){  // prefix[x2] <= prefix[x1] because bigger x2 will give shorter length
                dq.removeLast();
            }
            while(!dq.isEmpty() && prefix[y] >= prefix[dq.getFirst()] + k)
              ans = Math.min(ans, y - dq.removeFirst());

            dq.addLast(y);
        }
        return ans != n + 1 ? ans : - 1;
    }
}