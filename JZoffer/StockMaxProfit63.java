class Solution {
    /**
     * O(n)
     * O(1)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int res = 0;
        int min = prices[0];
        for (int p : prices) {
            min = Math.min(min, p);
            res = Math.max(res, p - min);
        }
        return res;
    }
}