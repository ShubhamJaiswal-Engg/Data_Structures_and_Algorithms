
// 2279. Maximum Bags With Full Capacity of Rocks

class MaxBagCapRock2279 {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {

        int n = capacity.length;
        int[] diff = new int[n];

        for (int i = 0; i < n; i++) {
            diff[i] = capacity[i] - rocks[i];
        }

        Arrays.sort(diff);

        // count bag with full capacity
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (diff[i] <= additionalRocks) {
                additionalRocks -= diff[i];
                cnt++;
            } else {
                break;
            }
        }

        return cnt;
    }
}
