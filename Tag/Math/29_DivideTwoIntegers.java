class Solution {
    /**
     * O(logn * logn)
     * O(logn)
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) sign = -1;
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        long res = helper(ldividend, ldivisor);
        if (res > Integer.MAX_VALUE) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return (int) res * sign;
    }

    public long helper(long ldividend, long ldivisor) {
        if (ldividend < ldivisor) return 0;
        long num = 1;
        long x = ldivisor;
        while (x + x < ldividend) {
            num += num;
            x += x;
        }
        return num + helper(ldividend - x, ldivisor);
    }
}