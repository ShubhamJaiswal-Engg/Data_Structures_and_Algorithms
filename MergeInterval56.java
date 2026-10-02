
// 56. Merge Intervals

class Solution {
    public int[][] merge(int[][] intervals) {
        // sort by start
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        for (int[] curr : intervals) {
            if (result.isEmpty() || result.get(result.size() - 1)[1] < curr[0]) {
                // start a new interval
                result.add(curr);
            } else {
                // extend the end of the last interval
                // Reference of Array
                int[] last = result.get(result.size() - 1);
                last[1] = Math.max(last[1], curr[1]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}