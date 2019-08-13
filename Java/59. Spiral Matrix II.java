class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        int rowb = 0;
        int rowe = n - 1;
        int colb = 0;
        int cole = n - 1;
        while (num <= n*n) {
            for (int i = colb; i <= cole; i++) {
                matrix[rowb][i] = num;
                num++;
            }
            rowb++;
            for (int i = rowb; i <= rowe; i++) {
                matrix[i][cole] = num;
                num++;
            }
            cole--;
            if (rowb <= rowe) {
                for (int i = cole; i>= colb; i--) {
                    matrix[rowe][i] = num;
                    num++;
                }
            }
            rowe--;
            if (colb <= cole) {
                for (int i = rowe; i>= rowb; i--) {
                    matrix[i][colb] = num;
                    num++;
                }
            }
            colb++;
        }
        return matrix;
    }
}
