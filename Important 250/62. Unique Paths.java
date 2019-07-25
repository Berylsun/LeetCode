//m*n, min(m, n)
class Solution {
    public int uniquePaths(int m, int n) {
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[j] += res[j - 1]; //res[j]代表左面的，res[j - 1]代表上边的；和二维的一个意思
            }
        }
        return res[n - 1];
    }
}
