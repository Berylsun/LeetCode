/**
 * O(n)
 * O(n)
 */
class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        int res = 0;
        for (int i = 0; i < candies.length - 1; i++) {
            if (ratings[i] < ratings[i + 1]) {
                candies[i + 1] = candies[i] + 1;
            }
        }
        for (int i = candies.length - 1; i > 0; i--) {
            if (ratings[i] < ratings[i - 1]) {
                candies[i - 1] = Math.max(candies[i - 1], candies[i] + 1);  // !!!
            }
        }

        for (int candy: candies) {
            res += candy;
        }
        return res;
    }
}