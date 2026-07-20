// 11. Container With Most Water

public class ContainerWithMostWater11 {
     public static int maxArea(int[] height) {
        int lp = 0;
        int rp = height.length - 1;
        int maxWater = 0;

        while( lp != rp) {
            int ht = Math.min(height[lp], height[rp]);
            int wt = rp - lp;
            int currWater = ht * wt;
            maxWater = Math.max(currWater, maxWater);

            if( height[lp] < height[rp]) {
                lp++;
            } else {
                rp--;
            };
        };
        return maxWater;
    };

    public static void main( String args[]) {
        int height[] = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}