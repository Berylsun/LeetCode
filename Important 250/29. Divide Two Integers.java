//logn, logn  dichotomy(二分法)
class Solution {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            sign = -1;
        }
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        long lres = ldivide(ldividend, ldivisor);
        if (lres > Integer.MAX_VALUE) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return sign * (int)lres;
    }
    
    public long ldivide(long ldividend, long ldivisor) {
        if (ldividend < ldivisor) return 0;
        long multiple = 1;
        long sum = ldivisor;
        while ((sum + sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }
        return multiple + ldivide(ldividend - sum, ldivisor);
    }
}
