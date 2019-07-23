//n^3, 1
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') continue;
                if (!valid(board, i, j)) return false;
            }
        }
        return true;
    }
    
    public boolean valid(char[][] board, int i, int j) {
        for (int row = 0; row < board.length; row++) {
            if (row == i) continue;
            if (board[row][j] == board[i][j]) return false;
        }
        
        for (int col = 0; col < board.length; col++) {
            if (col == j) continue;
            if (board[i][col] == board[i][j]) return false;
        }
        
        for (int row = 3 * (i / 3); row < 3 * (i / 3 + 1); row++) {
            for (int col = 3 * (j / 3); col < 3 * (j / 3 + 1); col++) {
                if (row == i && col == j) continue;
                if (board[row][col] == board[i][j]) return false;
            }
        }
        return true;
    }
}
