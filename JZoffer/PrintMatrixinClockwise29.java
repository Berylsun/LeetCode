class Solution {
    /**
     * O(mn)
     * O(mn)
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m * n];
        int rowBegin = 0;
        int colBegin = 0;
        int rowEnd = m - 1;
        int colEnd = n - 1;
        int idx = 0;
        while (idx < m * n) {
            for (int i = colBegin; i <= colEnd; i++) {
                res[idx++] = matrix[rowBegin][i];
            }
            rowBegin++;

            for (int i = rowBegin; i <= rowEnd; i++) {
                res[idx++] = matrix[i][colEnd];
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                for (int i = colEnd; i >= colBegin; i--) {
                    res[idx++] = matrix[rowEnd][i];
                }
                rowEnd--;
            }


            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    res[idx++] = matrix[i][colBegin];
                }
                colBegin++;
            }

        }
        return res;
    }
}