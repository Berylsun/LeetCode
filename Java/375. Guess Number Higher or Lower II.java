//n^3, n^2
class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return helper(1, n, dp);
    }
    
    public int helper(int i, int j, int[][] dp) {
        if (i >= j) return 0;
        if (dp[i][j] != 0) return dp[i][j];
        dp[i][j] = Integer.MAX_VALUE;
        for (int x = i; x <= j; x++) {
            dp[i][j] = Math.min(dp[i][j], Math.max(helper(i, x - 1, dp), helper(x + 1, j, dp)) + x);
        }
        return dp[i][j];
    }
}
