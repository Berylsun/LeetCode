class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}

/**
 * 并查集
 */
class Solution {
    private int count;
    private int[] record;
    public int numIslands(char[][] grid) {
        count = 0;
        if (grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        uf(grid);
        int nr = grid.length;
        int nc = grid[0].length;
        for (int r = 0 ; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    grid[r][c] = '0';
                    if (r - 1 >= 0 && grid[r-1][c] == '1') {
                        merge(r * nc + c, (r-1) * nc + c);
                    }
                    if (r + 1 < nr && grid[r+1][c] == '1') {
                        merge(r * nc + c, (r+1) * nc + c);
                    }
                    if (c - 1 >= 0 && grid[r][c-1] == '1') {
                        merge(r * nc + c, r * nc + c - 1);
                    }
                    if (c + 1 < nc && grid[r][c+1] == '1') {
                        merge(r * nc + c, r * nc + c + 1);
                    }
                }
            }
        }
        return count;
    }

    public void uf(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        record = new int[m*n];
        for (int i = 0 ; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    record[i * n + j] = i * n + j;
                    count++;
                }
            }
        }
    }

    public int findParent(int i) {
        if (record[i] != i) {
            record[i] = findParent(record[i]);
        }
        return record[i];
    }

    public void merge(int i, int j) {
        int x = findParent(i);
        int y = findParent(j);
        if (x != y) {
            count--;
            record[x] = y;
        }
    }
}