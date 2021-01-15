class Solution {
    /**
     * O(logn)
     * O(logn)
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0 || x == 1) return 1.0;
        if (n == Integer.MIN_VALUE) {
            return 1.0 / (myPow(x, Integer.MAX_VALUE) * x);
        }
        if (n < 0) return 1.0 / myPow(x, -n);
        double y = myPow(x, n / 2);
        if (n % 2 == 1) {
            return y * y * x;
        }
        return y * y;
    }

    /**
     * O(logn)
     * O(1)
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        long abs = Math.abs((long)n);
        double res = 1;
        while (abs > 0) {
            if (abs % 2 == 1) {
                res *= x;
            }
            x *= x;
            abs /= 2;
        }
        if (n < 0) return 1.0 / res;
        return res;
    }
}