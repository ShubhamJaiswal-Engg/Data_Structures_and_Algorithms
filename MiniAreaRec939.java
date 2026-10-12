
// 939. Minimum Area Rectangle

class MiniAreaRec939 {
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> recPoints = new HashMap<>();
        int n = points.length;

        for (int[] p : points) {
                recPoints.computeIfAbsent(p[0], k -> new HashSet<>()).add(p[1]);
            }

        // Another way to add map data 

        // for(int i = 0; i < n; i++) {
        //     // mapping
        //     if(!recPoints.containsKey(points[i][0])) {
        //         recPoints.put(points[i][0], new HashSet<>());
        //     }
        //     recPoints.get(points[i][0]).add(points[i][1]);
        // }

        boolean isAvailableRec = false;
        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                if(x1 == x2 || y1 == y2) continue;
                if(recPoints.get(x1).contains(y2) && recPoints.get(x2).contains(y1)) {
                    isAvailableRec = true;
                    ans = Math.min(ans, (Math.abs(x1 - x2) * Math.abs(y1 - y2)));
                }
            }
        }
        return isAvailableRec ? ans : 0;
    }
}