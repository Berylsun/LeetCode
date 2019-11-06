//m*n, m*n
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int res = 0;
        int[][] cache = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res = Math.max(res, dfs(matrix, i, j, Integer.MIN_VALUE, cache));
            }
        }
        return res;
    }
    
    public int dfs(int[][] matrix, int i, int j, int min, int[][] cache) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= min) return 0;
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        min = matrix[i][j];
        int left = dfs(matrix, i, j - 1, min, cache) + 1;
        int right = dfs(matrix, i, j + 1, min, cache) + 1;
        int up = dfs(matrix, i - 1, j, min, cache) + 1;
        int down = dfs(matrix, i + 1, j, min, cache) + 1;
        int res =  Math.max(Math.max(left, right), Math.max(up, down));
        cache[i][j] = res;
        return res;
    }
}
