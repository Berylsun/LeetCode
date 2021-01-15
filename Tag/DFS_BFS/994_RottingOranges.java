/**
 * O(m * n)
 * O(m * n)
 * BFS
 */
class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>(); //!!!!
        int fresh = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        if (fresh == 0) return 0; //!!!!!!
        int res = 0;
        while (!queue.isEmpty()){
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int row = cur[0];
                int col = cur[1];
                if (row > 0 && grid[row - 1][col] == 1) {
                    grid[row - 1][col] = 2;
                    fresh--;
                    queue.offer(new int[]{row - 1, col});
                }
                if (row < rows - 1 && grid[row + 1][col] == 1) {
                    grid[row + 1][col] = 2;
                    fresh--;
                    queue.offer(new int[]{row + 1, col});
                }
                if (col > 0 && grid[row][col - 1] == 1) {
                    grid[row][col - 1] = 2;
                    fresh--;
                    queue.offer(new int[]{row, col - 1});
                }
                if (col < cols - 1 && grid[row][col + 1] == 1) {
                    grid[row][col + 1] = 2;
                    fresh--;
                    queue.offer(new int[]{row, col + 1});
                }

            }
        }
        return fresh == 0 ? res - 1 : -1; //!!! res - 1
    }
}