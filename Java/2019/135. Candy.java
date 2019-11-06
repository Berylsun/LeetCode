//n, n
class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        int res = 0;
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        
        for (int i = 0; i < candies.length - 1; i++) {
            if (ratings[i] < ratings[i + 1]) {
                candies[i + 1] = candies[i] + 1;
            }
        }
        
        for (int i = candies.length - 2; i>= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i + 1] + 1, candies[i]);
            }
        }
        
        for (int candy : candies) {
            res += candy;
        }
        return res;
    }
}
