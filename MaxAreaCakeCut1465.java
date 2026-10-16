
// 1465. Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts

class MaxAreaCakeCut1465 {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        long maxH = maxGap(horizontalCuts, h);
        long maxW = maxGap(verticalCuts, w);

        return (int) ((maxH * maxW) % 1_000_000_007);
    }

    private int maxGap(int[] cuts, int limit) {
        int max = Math.max(cuts[0], limit - cuts[cuts.length - 1]);
        for (int i = 1; i < cuts.length; i++) {
            max = Math.max(max, cuts[i] - cuts[i - 1]);
        }
        return max;
    }
}