
// 36. Valid Sudoku

class ValidSudoku36 {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rowSet = new HashSet[9];
        Set<Character>[] colSet = new HashSet[9];
        Set<Character>[] boxSet = new HashSet[9];

        for(int i = 0; i < 9; i++) {
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
            boxSet[i] = new HashSet<>();
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                char ch = board[i][j];
                if(ch == '.') continue;

                if(rowSet[i].contains(ch) || colSet[j].contains(ch) || boxSet[(i / 3) * 3 + j / 3].contains(ch)) {
                    return false;
                }
                rowSet[i].add(ch);
                colSet[j].add(ch);
                boxSet[(i / 3) * 3 + j / 3].add(ch);
            }
        }
        return true;
    }
}