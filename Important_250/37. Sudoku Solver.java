//不知道， 不知道
class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) return;
        solve(board);
    }
    // be brave!!!
    public boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (valid(board, i, j, c)) {
                            board[i][j] = c;
                            if (!solve(board)) {
                                board[i][j] = '.';
                            }else {
                                return true;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean valid(char[][] board, int i, int j, char c) {
        for (int k = 0; k < board.length; k++) {
            if (board[k][j] == c) return false;
            if (board[i][k] == c) return false;
            if (board[3 * (i / 3) + k / 3 ][3 * (j / 3) + k % 3 ] == c) return false;
        }
        return true;
    }
}
