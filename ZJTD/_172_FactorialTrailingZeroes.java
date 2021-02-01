class Solution {
    /**
     * O(logn)
     * O(1)
     * res = n/5 + n/25 + n/125 + ......
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int res = 0;
        while (n != 0) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }
}