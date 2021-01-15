class Solution {
    /**
     * O(n)
     * O(1)
     */
    public int numWays(int n) {
        if (n <= 1) return 1;
        int a = 1;
        int b = 1;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return sum;
    }
}