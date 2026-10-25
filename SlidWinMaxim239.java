
// 239. Sliding Window Maximum

class SlidWinMaxim239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        int idx = 0;
        for(int i = 0; i < k; i++) {
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        for(int i = k; i < n; i++) {
            result[idx++] = nums[dq.peekFirst()];
             while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
             }
             dq.offerLast(i);
             while(!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
             }
        }
        result[idx++] = nums[dq.peekFirst()];

        return result;
    }
}