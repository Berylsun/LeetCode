class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return res;
        }
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, helper(grid,i, j));
                }
            }
        }
        return res;
    }

    public int helper(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 0;
        int res = 1;
        res += helper(grid, i - 1, j);
        res += helper(grid, i + 1, j);
        res += helper(grid, i, j - 1);
        res += helper(grid, i, j + 1);
        return res;
    }
}