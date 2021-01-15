class Solution {
    /**
     * O(n * m)
     * O(n * m)
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        int lens = s.length();
        int lent = t.length();
        int[][] dp = new int[lens + 1][lent + 1];
        for (int i = 0; i < s.length(); i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= lens; i++) {
            char cs = s.charAt(i - 1);
            for (int j = 1; j <= lent; j++) {
                char ct = t.charAt(j - 1);
                if (cs == ct) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[lens][lent];
    }
}