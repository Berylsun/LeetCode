//m*n, m*n
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 ) return 0;
        int res = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] cache = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(matrix, -1, i, j, cache);
                res = Math.max(res, cache[i][j]);
            }
        }
        
        return res;
    }
    
    public int dfs(int[][] matrix, int min, int i, int j, int[][] cache) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= min) {
            return 0;
        }
        
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        min = matrix[i][j];
        
        int a = dfs(matrix, min, i + 1, j, cache) + 1;
        int b = dfs(matrix, min, i - 1, j, cache) + 1;
        int c = dfs(matrix, min, i, j + 1, cache) + 1;
        int d = dfs(matrix, min, i, j - 1, cache) + 1;
        
        cache[i][j] = Math.max(a, Math.max(b, Math.max(c, d)));
        
        return cache[i][j];
    }
}
