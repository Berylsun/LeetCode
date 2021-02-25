class Solution {
    /**
     * O(n)
     * O(1)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int res = 0;
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            res = Math.max(res, prices[i] - buy);
            buy = Math.min(buy, prices[i]);
        }
        return res;
    }
}