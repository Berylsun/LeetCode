//厄拉多塞筛法，求一组质数，时间复杂度仅有O(nloglogn)
//如果从1到n-1分别判断质数，时间复杂度为O(nsqrt(n))）
class Solution {
    //厄拉多塞 Eratosthenes
    public int countPrimes(int n) {
        int res = 0;
        boolean[] notPrime = new boolean[n];
        
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                res++;
                for (int j = 2; j * i < n; j++) {
                    notPrime[i * j] = true;
                }
            }                        
        }        
        return res;
    }
}
