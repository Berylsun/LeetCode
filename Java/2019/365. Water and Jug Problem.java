class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (z == x || z == y || z == x + y) {
            return true;
        }
        return z % gcd(x,y) == 0;
    }
    
    
    // return z == mx + ny; => 找x、y 的最大公约数
    //gcd 最大公约数
    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
