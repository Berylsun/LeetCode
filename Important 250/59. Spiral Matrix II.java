//n, n
class Solution {
    public int[][] generateMatrix(int n) {
        if (n <= 0) return new int[][]{};
        int[][] res = new int[n][n];
        int i = 1;
        int rowBegin = 0;
        int rowEnd = n - 1;
        int colBegin = 0;
        int colEnd = n - 1;
        
        while (i <= n * n) {
            //->
            for (int j = colBegin; j <= colEnd; j++) {
                res[rowBegin][j] = i;
                i++;
            }
            rowBegin++;
            
            //v
            for (int j = rowBegin; j <= rowEnd; j++) {
                res[j][colEnd] = i;
                i++;
            }
            colEnd--;
            
            //<-
            if (rowBegin <= rowEnd) {
                for (int j = colEnd; j >= colBegin; j--) {
                    res[rowEnd][j] = i;
                    i++;
                }
            }
            rowEnd--;
            
            //^
            if (colBegin <= colEnd) {
                for (int j = rowEnd; j >= rowBegin; j--) {
                    res[j][colBegin] = i;
                    i++;
                }
            }
            colBegin++;
        }
        return res;
    }
}
