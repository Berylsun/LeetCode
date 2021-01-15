/**
 * O(n * k)
 * O(n * k)
 */
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k >= prices.length / 2) {
            return helper(prices);
        }
        int len = prices.length;
        int[][] dp = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            int buy = -prices[0];
            for (int j = 1; j < len; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], buy + prices[j]);
                buy = Math.max(buy, dp[i - 1][j - 1] - prices[j]);
            }
        }
        return dp[k][len - 1];
    }

    public int helper(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }
}