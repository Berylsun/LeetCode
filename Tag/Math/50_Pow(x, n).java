class Solution {
    /**
     * O(logn)
     * O(logn)/O(1)
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n > 0) {
            return pow(x, n);
        } else {
            return 1 / pow(x, n);
        }
    }

    public double pow(double x, long n) {
        if (n == 0) return 1;
        double y = pow(x, n / 2);
        if (n % 2 != 0) {  // n % 2 == -1 || n % 2 == 1
            return y * y * x;
        } else {
            return y * y;
        }
    }

    public double myPow(double x, int n) {
        if (n > 0) {
            return pow2(x, (long)n);
        } else {
            return 1 / pow2(x, 0 - (long)n);
        }
    }

    public double pow2(double x, long n) {
        if (n == 0) return 1;
        double y = pow2(x, n / 2);
        if (n % 2 == 1) {
            return y * y * x;
        } else {
            return y * y;
        }
    }


    public double myPow3(double x, int n) {
        if (n == 0) return 1;
        double res = 1;
        long abs = Math.abs((long)n);
        while (abs > 0) {
            if (abs % 2 == 1) {
                res *= x;
            }
            x *= x;
            abs /= 2;
        }
        if (n < 0) {
            return 1 / res;
        }
        return res;
    }
}