class Solution {
    //9: 3 3 3
    //10: 3 3 4
    //11: 3 3 3 2
    //12: 3 3 3 3   ……
    public int integerBreak(int n) {
        if (n == 2 || n == 3) return n - 1;
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        return n * res;
    }
}
