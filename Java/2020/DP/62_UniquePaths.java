class Solution {
    /**
     * O(m * n)
     * O(m * n)
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    /**
     * O(m * n)
     * O(n)
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[j] = res[j] + res[j - 1];
            }
        }
        return res[n - 1];
    }


    /**
     * Combination(Count, k) = count! / (k!*(count - k)!)
     * C = (count - k + 1) * (count - k + 2) .../k!
     * time : O(m)
     * space : (1)
     * @param m
     * @param n
     * @return
     */

    public int uniquePaths3(int m, int n) {
        int count = m + n - 2;
        int k = m - 1;
        double res = 1;
        for (int i = 1; i <= k; i++) {
            res = res * (count - k + i) / i;
        }
        return (int)res;
    }
}