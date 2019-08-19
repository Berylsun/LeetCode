//m^2*n^2, m*n
BFS!!!
/*
For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):

     1 - 0 - 2 - 0 - 1
     |   |   |   |   |
     0 - 0 - 0 - 0 - 0
     |   |   |   |   |
     0 - 0 - 1 - 0 - 0

     The point (1,2) is an ideal empty land to build a house,
     as the total travel distance of 3+3+1=7 is minimal. So return 7.
*/

public int shortestDistance(int[][] grid) {
    if (grid == null || grid.length == 0) return -1;
    int m = grid.length;
    int n = grid[0].length;
    int buildSum = 0;
    int[][] dist = new int[m][n];
    int[][] nums = new int[m][n];
    
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (grid[i][j] == 1) {
                buildSum++;
                bfs(grid, i, j, dist, nums);
            }
        }
    }
    
    int res = Integer.MAX_VALUE;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (grid[i][j] == 0 && dist[i][j] != 0 && nums[i][j] == buildSum) {
                res = Math.min(res, dist[i][j]);
            }
        }
    }
    
    return res == Integer.MAX_VALUE ? -1 : res;
}

public void bfs(int[][] grid, int row, int col, int[][] dist, int[][] nums) {
    int m = grid.length;
    int n = grid[0].length;

    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{row, col});
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    boolean[][] visited = new boolean[m][n];
    int distance = 0;
    
    while (!queue.isEmpty()) {
        int size = queue.size();
        distance++;
        for (int i = 0; i < size; i++) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && grid[x][y] == 0) {
                    visited[x][y] = true;
                    dist[x][y] += distance;
                    nums[x][y]++;
                    queue.offer(new int[]{x, y});
                }
            }
        }
    }
}
