//k^2, m*n
int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
public List<Integer> numIslands2(int m, int n, int[][] positions) {
    List<Integer> res = new ArrayList<>();
    if (m <= 0 || n <= 0) return res;
    int count = 0;
    int[] roots = new int[m*n];
    Arrays.fill(roots, -1);
    
    for (int[] pair : positions) {
        int position = n * pair[0] + pair[1];
        if (roots[position] != -1) {
            res.add(count);
        }
        roots[position] = position;
        count++;
        
        for (int[] dir : dirs) {
            int x = pair[0] + dir[0];
            int y = pair[1] + dir[1];
            int curPos = n * x + y;
            if (x < 0 || x >= m || y < 0 || y >=n || roots[curPos] == -1) continue;
            int anoIsland = find(roots, curPos);
            if (position != anoIsland) {
                roots[positon] = anoIsland;
                position = anoIsland;
                count--;
            }
        }
        res.add(count);
    }
    return res;
}

public int find(int[] roots, int i) {
    if (i != roots[i]) {
        i = roots[i];
    }
    return i;
}
