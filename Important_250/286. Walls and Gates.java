//m*n, n
/*
For example, given the 2D grid:
     INF  -1  0  INF
     INF INF INF  -1
     INF  -1 INF  -1
     0  -1 INF INF

 After running your function, the 2D grid should be:
     3  -1   0   1
     2   2   1  -1
     1  -1   2  -1
     0  -1   3   4
*/
public void wallsAndGates(int[][] rooms) {
    if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
    
    for (int i = 0; i < rooms.length; i++) {
        for (int j = 0; j < rooms[0].length; j++) {
            if (rooms[i][j] == 0) {
                dfs(rooms, i, j, 0);
            }
        }  
    }
}

public void dfs(int[][] rooms, int i, int j, int dis) {
    if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] < dis) return;
    rooms[i][j] = dis;
    dfs(rooms, i - 1, j, dis + 1);
    dfs(rooms, i + 1, j, dis + 1);
    dfs(rooms, i, j + 1, dis + 1);
    dfs(rooms, i, j - 1, dis + 1);
}

//BFS (不会产生数值比赋值小的情况， 因为bfs是一层一层走的， 赋的值一定是最小的) ！！！
    public void wallsAndGates2(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] top = queue.remove();
            int row = top[0], col = top[1];
            if (row > 0 && rooms[row - 1][col] == Integer.MAX_VALUE) {
                rooms[row - 1][col] = rooms[row][col] + 1;
                queue.add(new int[]{row - 1, col});
            }
            if (row < rooms.length - 1 && rooms[row + 1][col] == Integer.MAX_VALUE) {
                rooms[row + 1][col] = rooms[row][col] + 1;
                queue.add(new int[]{row + 1, col});
            }
            if (col > 0 && rooms[row][col - 1] == Integer.MAX_VALUE) {
                rooms[row][col - 1] = rooms[row][col] + 1;
                queue.add(new int[]{row, col - 1});
            }
            if (col < rooms[0].length - 1 && rooms[row][col + 1] == Integer.MAX_VALUE) {
                rooms[row][col + 1] = rooms[row][col] + 1;
                queue.add(new int[]{row, col + 1});
            }
        }
    }
