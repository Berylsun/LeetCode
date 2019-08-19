//
Union Find!!!
/*
Example:

     Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
     Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).

     0 0 0
     0 0 0
     0 0 0
     Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

     1 0 0
     0 0 0   Number of islands = 1
     0 0 0
     Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

     1 1 0
     0 0 0   Number of islands = 1
     0 0 0
     Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.

     1 1 0
     0 0 1   Number of islands = 2
     0 0 0
     Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

     1 1 0
     0 0 1   Number of islands = 3
     0 1 0
     We return the result as an array: [1, 1, 2, 3]
*/

int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
public List<Integer> numIslands2(int m, int n, int[][] positions) {
    int[] roots = new int[m*n];
    List<Integer> res = new ArrayList<>();
    if (m <= 0 || n <= 0) return res;
    Arrays.fill(roots, -1);
    int count = 0;
    
    for(int[] pair : positions) {
        int position = n * pair[0] + pair[1];
        if (roots[position] != -1) {
            res.add(count);
            continue;
        }
        roots[position] = position;
        count++;
        
        for (int[] dir : dirs) {
            int x = pair[0] + dir[0];
            int y = pair[1] + dir[1];
            
            if (x < 0 || x >= m || y < 0 || y >=n || roots[curPos] == -1) continue;
            int anoIsland = find(roots, curPos);
            if (position != anoIsland) {
                roots[position] = anoIsland;
                position = anoIsland;
                count--;
            }
        }
        res.add(count);
    }
    
    return res;
}

public int find(int[] roots, int i) {
    while (i != roots[i]) {
        i = roots[i];
    }
    return i;
}
