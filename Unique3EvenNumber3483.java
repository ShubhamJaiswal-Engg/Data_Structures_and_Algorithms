
// 3483. Unique 3-Digit Even Numbers

class Solution {
    public int totalNumbers(int[] digits) {
        int mp[] = new int[10];
        for (int idx : digits) {
            mp[idx]++;
        }
        int result = 0;
        for (int i = 1; i < 10; i++) {
            if (mp[i] == 0) continue;
            mp[i]--;
            for (int j = 0; j < 10; j++) {
                if (mp[j] == 0) continue;
                mp[j]--;
                for (int k = 0; k < 10; k++) {
                    if (mp[k] == 0) continue;
                    mp[k]--;
                    if ((i + j + k) % 2 == 0) {
                        result++;
                    }
                    mp[k]++;   // backtrack
                }
                mp[j]++;       // backtrack
            }
            mp[i]++;           // backtrack
        }
        return result;
    }
}