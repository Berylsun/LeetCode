//n, 1
class Solution {
    public int maxProfit(int[] prices) {
        int sell = 0, preSell = 0;
        int buy = Integer.MIN_VALUE, preBuy = 0;
        for (int price : prices) {
            preBuy = buy;
            buy = Math.max(preSell - price, preBuy);
            preSell = sell;
            sell = Math.max(preSell, preBuy + price);
        }
        return sell;
    }
}
