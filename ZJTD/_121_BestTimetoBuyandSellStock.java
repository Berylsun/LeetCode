class Solution {
    /**
     * O(n)
     * O(1)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int res = 0;
        if (prices == null || prices.length == 0) return res;
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > buy) {
                res = Math.max(res, prices[i] - buy);
            } else {
                buy = prices[i];
            }
        }
        return res;
    }
}