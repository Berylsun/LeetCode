//logn, 1
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        long abs = Math.abs((long)n);
        double res = 1;
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

//logn, n
class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            return 1.0 / pow(x, -n);
        }else {
            return pow(x, n);
        }
    }
    
    public double pow(double x, int n) {
        if (n == 0) return 1;
        double y = pow(x, n / 2);
        if (n % 2 == 0) {
            return y * y;
        }else {
            return y * y * x;
        }
    }
}
