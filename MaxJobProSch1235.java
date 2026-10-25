
// 1235. Maximum Profit in Job Scheduling

class MaxJobProSch1235 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[1], b[1]));

        int[] dp = new int[n];
        dp[0] = jobs[0][2];
        for (int i = 1; i < n; i++) {
            int start = 0, end = i - 1, ans = -1;
            // binary search
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (jobs[mid][1] <= jobs[i][0]) {
                    ans = mid;
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            int take = jobs[i][2] + (ans == -1 ? 0 : dp[ans]);
            dp[i] = Math.max(dp[i - 1], take);
        }
        return dp[n - 1];
    }
}