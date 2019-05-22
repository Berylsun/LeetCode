class Solution {
    public int mySqrt(int x) {
        if (x <= 0) {
            return 0;
        }
        int  low = 1;
        int high = x;
        while (low <= high) {
            long mid = (high - low) / 2 + low;
            if (mid * mid == x) {
                return (int)mid;
            }else if (mid * mid < x) {
                low = (int)mid + 1;
            }else {
                high = (int)mid - 1;
            }
        }
        return high;
    }
}

class Solution {
    public int mySqrt(int x) {
        long res = x;
        while (res * res > x) {
            res = (res + x / res) / 2;
        }
        return (int)res;
    }
}
