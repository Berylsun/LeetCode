class Solution {
    /**
     * O(mn)
     * O(mn)
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        int[][] sq = new int[m][n];
        helper(sq, 0, 0, k);
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (sq[i][j] != 0) {
                    res++;
                }
            }
        }
        return res;
    }

    public void helper(int[][] sq, int i, int j, int k) {
        if (i < 0 || i >= sq.length || j < 0 || j >= sq[0].length || sq[i][j] == 1 ||!inPos(i, j, k)) return;
        sq[i][j] = 1;
        helper(sq, i + 1, j, k);
        helper(sq, i - 1, j, k);
        helper(sq, i, j + 1, k);
        helper(sq, i, j - 1, k);
    }

    public boolean inPos(int i, int j, int k) {
        int res = 0;
        while (i != 0) {
            res += i % 10;
            i /= 10;
        }
        while (j != 0) {
            res += j % 10;
            j /= 10;
        }
        if (res > k) return false;
        return true;
    }
}