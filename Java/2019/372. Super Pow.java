class Solution {
    public int superPow(int a, int[] b) {
        return superpow(a, b, b.length, 1337);
    }
    
    public int superpow (int a, int[] b, int length, int k) {
        if (length == 1) {
            return powmod(a, b[0], k);
        }
        //[3, 1] -> a^30 * a^1;
        return powmod(superpow(a, b, length - 1, k), 10, k) * powmod(a,b[length - 1],k) % k;
    }
    
    
    // (a * b) % c = (a % c) * ( b % c) % c;
    public int powmod(int x, int y, int k) {
        x %= k;
        int pow = 1;
        for (int i = 0; i < y; i++) {
            pow = pow * x % k;
        }
        return pow;
    }
}
