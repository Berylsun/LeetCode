class Solution {
    /**
     * O(n^2)
     * O(1)
     * @param matrix
     * @return
     */
    public int countSquares(int[][] matrix) {
        int res = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] > 0 && i > 0 && j > 0) {
                    matrix[i][j] = Math.min(matrix[i - 1][j - 1], Math.min(matrix[i][j - 1], matrix[i - 1][j])) + 1;
                }
                res += matrix[i][j];
            }
        }
        return res;
    }
}