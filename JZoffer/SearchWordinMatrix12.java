class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        if (word == null || word.length() == 0) return true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean helper(char[][] board, String word, int i, int j, int index) {
        if (index >= word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if (board[i][j] != word.charAt(index)) return false;
        char c = board[i][j];
        board[i][j] = '#';

        // optimize time by use "||"
        boolean res = helper(board, word, i, j - 1, index + 1)
                || helper(board, word, i, j + 1, index + 1)
                || helper(board, word, i - 1, j, index + 1)
                || helper(board, word, i + 1, j, index + 1);
        board[i][j] = c;
        return res;
    }
}