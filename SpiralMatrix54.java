
// 54. Spiral Matrix

class SpiralMatrix54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int startRow = 0;
        int endRow = matrix.length - 1;
        int startCol = 0;
        int endCol = matrix[0].length - 1;
        List<Integer> ans = new ArrayList<>();

        while(startRow <= endRow && startCol <= endCol) {

            // top
            for(int i = startCol; i <=endCol; i++) {
                ans.add(matrix[startRow][i]);
            }

            // right
            for(int i = startRow + 1; i <=endRow; i++) {
                ans.add(matrix[i][endCol]);
            }

            // bottom
            for(int i = endCol - 1; i >= startCol; i--) {
                if(startRow == endRow) break;
                ans.add(matrix[endRow][i]);
            }

            // left 
            for(int i = endRow - 1; i >= startRow + 1; i--) {
                if(startCol == endCol) break;
                ans.add(matrix[i][startCol]);
            }
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
        return ans;
    }
}