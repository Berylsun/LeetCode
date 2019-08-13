class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = numLiveNeighbors(board, i, j);
                if (board[i][j] == 1) {
                    if (count == 2 || count == 3) {
                        board[i][j] += 2;
                    }
                }else if (count == 3) {
                    board[i][j] += 2;
                }
            }
        }
         for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] >>= 1;
            }   
        }
    }
    
    public int numLiveNeighbors(int[][]board,int row,int col) {
        int res = 0;
        for (int i = Math.max(row - 1, 0); i <= Math.min(board.length - 1, row + 1); i++) {
            for (int j = Math.max(col - 1, 0); j <= Math.min(board[0].length - 1, col + 1); j++) {
                if (!(i == row && j == col)) {
                    if ((board[i][j] & 1) == 1) {
                        res++;
                    }
                }
            }   
        }
        return res;
    }
}
