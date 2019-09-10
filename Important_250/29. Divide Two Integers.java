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
        long multiple = 1; //must be long, because if it larger than Integer.MAX_VALUE, it will become minus value!!!
        long sum = ldivisor;
        
        //unchange ldividend, know how many ldividend in ldividend!!!
        while ((sum + sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }
        return multiple + ldivide(ldividend - sum, ldivisor);
    }
}
