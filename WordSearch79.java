
// 79. Word Search

class WordSearch79 {

    private boolean dfs(int i, int j, String word, char[][] board) {

        // When Word length is Zero means we what ever we want
        if(word.length() == 0) return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '.') return false;

        if(board[i][j] == word.charAt(0)) {

            // To Stop visting again
            board[i][j] = '.';

            // Ans is here to stop calling recursion again and again
            boolean ans = false;

            ans = ans || dfs(i + 1, j, word.substring(1), board) || dfs(i - 1, j, word.substring(1), board) || dfs(i, j + 1, word.substring(1), board) ||
            dfs(i, j - 1, word.substring(1), board);

            // Back Tracking
            board[i][j] = word.charAt(0);
            return ans;
        }
      return false;
    }
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(dfs(i , j, word, board)) return true;
            }
        };
        return false;
    }
}

// Another Option

class WordSearch79 {
    public boolean exist(char[][] board, String word) {
        for(int i = 0 ; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(dfs(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int row, int col, int index){

        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length){
            return false;
        }

        if(board[row][col] != word.charAt(index)){
            return false;
        }

        if(index == word.length() - 1){
            return true;
        }

        char temp = board[row][col];
        board[row][col] = '#';

        boolean found = dfs(board, word, row, col+1, index+1) ||
                        dfs(board, word, row, col-1, index+1) ||
                        dfs(board, word, row+1, col, index+1) ||
                        dfs(board, word, row-1, col, index+1);

        board[row][col] = temp;

        return found;
    }
}