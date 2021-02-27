class Solution {
    /**
     * unknown
     * unknown
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) return true;
        if (board.length == 0 || board[0] == null || board[0].length == 0) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (helper(board, i, j, word, 0, new HashSet<>())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean helper(char[][] board, int i, int j, String word, int idx, HashSet<String>set) {
        if (idx >= word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if (set.contains(i + "-" + j) || board[i][j] != word.charAt(idx)) return false;
        set.add(i + "-" + j);
        boolean res = helper(board, i + 1, j, word, idx + 1, set) ||
                helper(board, i - 1, j, word, idx + 1, set) ||
                helper(board, i, j + 1, word, idx + 1, set) ||
                helper(board, i, j - 1, word, idx + 1, set);
        set.remove(i + "-" + j);
        return res;
    }
}