
// 2100. Find Good Days to Rob the Bank

class FndGDToRobBnk2100 {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        List<Integer> list = new ArrayList<>();
        if (n == 0) return list;

        int[] nonIncreasing = new int[n]; 
        
        int[] nonDecreasing = new int[n]; 

        for (int i = 1; i < n; i++) {
            if (security[i] <= security[i - 1]) nonIncreasing[i] = nonIncreasing[i - 1] + 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (security[i] <= security[i + 1]) nonDecreasing[i] = nonDecreasing[i + 1] + 1;
        }

        for (int i = 0; i < n; i++) {
            if (nonIncreasing[i] >= time && nonDecreasing[i] >= time) {
                list.add(i);
            }
        }
        return list;
    }
}