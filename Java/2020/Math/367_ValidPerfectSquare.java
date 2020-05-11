class Solution {
    /**
     * O(sqrt(n))
     * O(1)
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        for (int i = 1; i <= num / i; i++) {
            if (i * i == num) return true;
        }
        return false;
    }

    /**
     * O(logn)
     * O(1)
     * @param num
     * @return
     */
    public boolean isPerfectSquare2(int num) {
        int i = 1;
        int j = num;
        while (i <= j) {
            long mid = (j - i) / 2 + i;
            if (mid * mid == num) return true;
            if (mid * mid < num) {
                i = (int)mid + 1;
            } else {
                j = (int)mid - 1;
            }
        }
        return false;
    }

    /**
     * unknown
     * O(1)
     * Newton Method: y = f(x0) + f'(x0)(x - x0)
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        long x = num;
        while (x * x > num) {
            x = (x + num / x) / 2;
        }
        return x * x == num;
    }
}