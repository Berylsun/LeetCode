class Solution {
    /**
     * timeout
     * dfs
     */
    int res = 0;
    public int maxValue(int[][] grid) {
        dfs(grid, 0, 0, 0);
        return res;
    }

    public void dfs(int[][] grid, int i, int j, int num) {
        res = Math.max(res, num);
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
        dfs(grid, i + 1, j, num + grid[i][j]);
        dfs(grid, i, j + 1, num + grid[i][j]);
    }


    /**
     * dp
     * O(mn)
     * O(1)
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            grid[0][i] += grid[0][i - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }
}