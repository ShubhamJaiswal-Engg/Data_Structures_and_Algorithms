


class BeautiArrange526 {

    private int perm(boolean vis[], int pos, int n) {

        if(pos > n) return 1; // means 1 possible beautiful arrangement

        int cnt = 0;
        for(int num = 1; num <= n; num++) {
            if(vis[num] == false && (num % pos == 0 || pos % num == 0)) {
                vis[num] = true; // making busy
                cnt += perm(vis, pos + 1, n);
                // backtracking
                vis[num] = false;
            }
        }
        return cnt;
    }
    public int countArrangement(int n) {
        if(n == 1) {
            return 1;
        }
        boolean vis[] = new boolean[n + 1]; // n + 1 size means using 1-indexed 
        // 1-Indexed
        return perm(vis, 1, n);
    }
}