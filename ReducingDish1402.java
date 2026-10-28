
// 1402. Reducing Dishes

class ReducingDish1402 {
    int dp[][];
    public int maxSatisfaction(int[] satisfaction) {
        dp = new int[satisfaction.length + 1][501];
        for(int i = 0; i < satisfaction.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        Arrays.sort(satisfaction);
        return maxDish(satisfaction, 0, 1, dp);
    }

    private int maxDish(int[] satisfaction, int dish, int time, int dp[][]) {
        if(dish == satisfaction.length) return 0;

        if(dp[dish][time] != -1) {
            return dp[dish][time];
        }

        int take = satisfaction[dish] * time + maxDish(satisfaction, dish + 1, time + 1, dp);
        int not_take = maxDish(satisfaction, dish + 1, time,dp);

        return  dp[dish][time] = Math.max(take, not_take);
    }
}

class ReducingDish1402 {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);

        int suffixSum = 0;
        int totalDishCook = 0;
        // a * 1 + b * 2 + c * 3 
        // a + b + c , b + c, c
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            suffixSum += satisfaction[i];

            if (suffixSum <= 0) {
                break;
            }

            totalDishCook += suffixSum;
        }

        return totalDishCook;
    }
}