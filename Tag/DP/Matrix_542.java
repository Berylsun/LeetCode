public class Matrix_542 {
    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0] == null || mat[0].length == 0) return mat;
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = mat[i][j] == 0 ? 0 : Integer.MAX_VALUE / 2;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] != 0) {
                    if ((i - 1) >= 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                    }
                    if ((j - 1) >= 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                    }
                }
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (dp[i][j] != 0) {
                    if ((i + 1) < m) {
                        dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                    }
                    if ((j + 1) < n) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                    }
                }
            }
        }
        return dp;
    }
}
