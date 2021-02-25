class Solution {
    /**
     * O(n)
     * O(n)
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n < 3) return n;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    /**
     * O(n)
     * O(1)
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if (n < 3) return n;
        int one = 1;
        int two = 2;
        int res = 0;
        for (int i = 2; i < n; i++) {
            res = one + two;
            one = two;
            two = res;
        }
        return res;
    }
}