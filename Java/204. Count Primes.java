class Solution {
    public int countPrimes(int n) {
        //厄拉多塞筛法
        boolean[] notPrime = new boolean[n];
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                res++;
            }
            //j必须从2开始，不能从i开始，因为数值过大的时候相乘为负数
            for (int j = 2; i * j < n; j++) { 
                notPrime[i*j] = true;
            }
        }
        return res;
    }
}
