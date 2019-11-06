    //O(m * n), O(n)
    public int minTotalDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        List<Integer> I = new ArrayList<>();
        List<Integer> J = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
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
        int sum = 0;
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            sum += list.get(j--) - list.get(i++);
        }
        return sum;
    } 
