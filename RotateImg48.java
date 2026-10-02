
// 48. Rotate Image

class RotateImg48 {
    public void rotate(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;
        // Transposing matrix
        for(int i = 0; i < row; i++) {
            for(int j = i + 1; j < col; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            };
        };

        // Reverse matrix
        for(int i = 0; i < row; i++) {
            int r = 0, c = col - 1;
            while(r < c) {
            // Swaping
            int temp = matrix[i][c];
            matrix[i][c] = matrix[i][r];
            matrix[i][r] = temp;
                 r++;
                 c--;
            };
        };
    };
};