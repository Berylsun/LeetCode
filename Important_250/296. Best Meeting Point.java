//
2D -> 2 * 1D
public int minTotalDistance(int[][] grid) {
    if (grid == null || grid.length == 0 || gird[0].length == 0) return 0;
    
    int m = grid.length;
    int n = grid[0].length;
    List<Integer> I = new ArrayList<>();
    List<Integer> J = new ArrayList<>();
    
    //put index in ascending order
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (grid[i][j] == 0) {
                I.add(i);
            }
        }
    }
    
    for (int j = 0; j < n; j++) {
        for (int i = 0; i < m; i++) {
            if (grid[i][j] == 1) {
                J.add(j);
            }
        }
    }
    
    return min(I) + min(J);
}

public int min(List<Integer> list) {
    int num = 0;
    int i = 0;
    int j = list.size() - 1;
    while (i < j) {
        num += list.get(j--) - list.get(i++);
    }
    return num;
}
