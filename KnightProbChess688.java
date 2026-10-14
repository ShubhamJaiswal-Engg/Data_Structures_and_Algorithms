
// 688. Knight Probability in Chessboard

class KnightProbChess688 {
    public double knightProbability(int n, int k, int row, int column) {
        double [][][] knightMoves = new double [k + 1][n][n];
        int dir[][] = {{1, 2},{1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
        knightMoves[0][row][column] = 1.0;

        for(int moves = 1; moves < knightMoves.length; moves++) {

            for(int i = 0; i < n; i++) {
                for(int j =0; j < n; j++) {
                    for(int [] direction : dir) {
                        int prevI = i - direction[0];
                        int prevJ = j - direction[1];
                        if(prevI >= 0 && prevI < n && prevJ >= 0 && prevJ < n) {
                        knightMoves[moves][i][j] += knightMoves[moves - 1][prevI][prevJ] / 8.0;
                        }
                    }
                }
            }
        }
            double result = 0.0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    result += knightMoves[k][i][j];
                }
            }
            return result;
    }
}