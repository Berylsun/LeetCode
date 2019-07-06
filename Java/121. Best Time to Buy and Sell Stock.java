/n, 1
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int res = 0;
        int min = prices[0];
        for (int num : prices) {
            min = Math.min(min, num);
            res = Math.max(res, num - min);
        }
        return res;
    }
}
