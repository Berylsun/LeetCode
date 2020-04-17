public class Solution {
    /**
     * time : O(1) / O(logn)
     * space : O(1)
     * 使用n&(n-1)的方法：n&(n-1)作用：将n的二进制表示中的最低位为1的改为0
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += n & 1;
            n >>= 1;
        }
        return res;
    }
    public int hammingWeight2(int n) {
        int res = 0;
        while (n != 0) {
            n &= (n - 1);
            res++;
        }
        return res;
    }
}
