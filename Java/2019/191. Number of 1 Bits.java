public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32 ; i++) {
            res += n & 1;
            n >>= 1;
        }
        return res;
    }
}


public class Solution {
    // you need to treat n as an unsigned value
    // n & (n - 1) 将n的二进制表示中的最低位的1改为0
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n &= (n - 1);
            res ++;
        }
        return res;
    }
}
