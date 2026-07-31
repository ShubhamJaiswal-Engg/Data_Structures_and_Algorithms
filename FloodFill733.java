// 733. Flood Fill

class floodFill733 {
    public void helper(int[][] image, int sr, int sc, int color, int orgColor, boolean vis[][]) {
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != orgColor || vis[sr][sc]) return;

        image[sr][sc] = color;
        vis[sr][sc] = true;

        // left
        helper(image, sr, sc + 1, color, orgColor, vis);

        // right
        helper(image, sr, sc - 1, color, orgColor, vis);

        // up
        helper(image, sr + 1, sc, color, orgColor, vis);

        // down
        helper(image, sr - 1, sc,  color, orgColor, vis);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        boolean vis[][] = new boolean [image.length][image[0].length];
        helper(image, sr, sc, color, image[sr][sc], vis);
        return image;
    }
}