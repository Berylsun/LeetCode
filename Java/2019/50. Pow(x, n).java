class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
        }
        long num = Math.abs((long)n);
        return pow(x, num);
    }
    
    public double pow(double x, long n) {
        if (n == 0) {
            return 1;
        }
        double y = pow(x, n / 2);
        if (n % 2 == 0) {
            y *= y;
        }else {
            y = y * y * x;
        }
        return y;
    }
}
