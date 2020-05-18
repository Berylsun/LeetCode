class Solution {
    /**
     * O(logn)
     * O(1)
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        long i = 1;
        long j = x;
        while (i <= j) {
            long mid = (j - i) / 2 + i;
            if (mid * mid == x) {
                return (int)mid;
            }
            if (mid * mid < x) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return (int)j;
    }

    //newton the same with LC367
    public int mySqrt(int x) {
        long num = x;
        while (num * num > x) {
            num = (x / num + num) / 2;
        }
        return (int)num;
    }
}