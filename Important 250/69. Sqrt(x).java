//logn, 1
class Solution {
    public int mySqrt(int x) {
        if (x <= 0) return 0;
        long low = 1;
        long high = x;
        while (low + 1 < high) {
            long mid = (high - low) / 2 + low;
            if (mid * mid == x) return (int)mid;
            if (mid * mid < x) {
                low = mid;
            }else {
                high = mid;
            }
        }
        return (int)low;
    }
}
