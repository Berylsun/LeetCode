/**
 * O(m * n)
 * O(1)
 */
class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = liveNeighbor(board, i, j);
                if (board[i][j] == 1) {
                    if (count == 2 || count == 3) {
                        board[i][j] += 2;
                    }
                } else if (count == 3) {
                    board[i][j] += 2;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
    }

    public int liveNeighbor(int[][] board, int i, int j) {
        int count = 0;
        for (int row = Math.max(0, i - 1); row <= Math.min(i + 1, board.length - 1); row++) {
            for (int col = Math.max(0, j - 1); col <= Math.min(j + 1, board[0].length - 1); col++) {
                if (row == i && col == j) continue;
                if ((board[row][col] & 1) == 1) count++;
            }
        }
        return count;
    }
}