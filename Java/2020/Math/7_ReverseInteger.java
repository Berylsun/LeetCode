class Solution {
    /**
     * O(logn)
     * O(1)
     * 越界
     * @param x
     * @return
     */
    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)res;
    }
}