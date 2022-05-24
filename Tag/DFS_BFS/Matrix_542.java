public class Matrix_542 {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] dir = new int[][]{{0,-1},{0, 1}, {-1, 0},{1, 0}};
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i,j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            for (int i = 0; i < 4; i++) {
                int newx = x + dir[i][0];
                int newy = y + dir[i][1];
                if (newx >= 0 && newx < m && newy >= 0 && newy < n && mat[newx][newy] == -1) {
                    mat[newx][newy] = mat[x][y] + 1;
                    queue.offer(new int[]{newx, newy});
                }
            }
        }
        return mat;
    }
}
