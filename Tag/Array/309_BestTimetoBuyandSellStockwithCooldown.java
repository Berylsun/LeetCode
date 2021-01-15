/**
 * O(n)
 * O(1)
 */
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int prebuy = -prices[0];
        int buy = -prices[0];
        int presell = 0;
        int sell = 0;

        for (int i = 1; i < prices.length; i++) {
            prebuy = buy;
            buy = Math.max(prebuy, presell - prices[i]);
            presell = sell;
            sell = Math.max(presell, prebuy + prices[i]);
        }

        return sell;
    }
}