//n, 1
DP!!!
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int sell = 0;
        int preSell = 0;
        int buy = Integer.MIN_VALUE;
        int preBuy = 0;
        
        for (int price : prices) {
            preBuy = buy;
            buy = Math.max(preSell - price, preBuy);
            preSell = sell;
            sell = Math.max(preSell, preBuy + price);
        }
        
        return sell;
    }
}
