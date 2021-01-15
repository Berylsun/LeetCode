class Solution {
    /**
     * O(logn)
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        if (n < 4) return n - 1;
        int count = 0;
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        return n * res;
    }

    public int cuttingRope(int n) {
        if(n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if(b == 0) return (int)Math.pow(3, a);
        if(b == 1) return (int)Math.pow(3, a - 1) * 4;
        return (int)Math.pow(3, a) * 2;
    }
}