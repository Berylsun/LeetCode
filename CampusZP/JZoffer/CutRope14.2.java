class Solution {
    /**
     * O(logn)
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        if (n < 4) return n - 1;
        int count = 0;
        long res = 1; //!!!
        while (n > 4) {
            res *= 3;
            res %= 1000000007;
            n -= 3;
        }
        return (int)(n * res % 1000000007);
    }
}