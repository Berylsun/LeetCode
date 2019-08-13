class Solution {
    public int integerReplacement(int n) {
        // 位运算：倒数第二位是0的话->减1，使0变多，相反则加1；
        long N = n;
        int res = 0;
        while (N != 1) {
            if (N % 2 == 0) {
                N >>= 1;
            }else {
                if (N == 3) {
                    res += 2;
                    break;
                }
                if ((N & 2) == 2) {
                    N++;
                }else {
                    N--;
                }
            }
            res++;
        }
        return res;
    }
}


class Solution {
    public int integerReplacement(int n) {
        int res = 0;
        if (n == Integer.MAX_VALUE) return 32;
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            }else {
                if ((n + 1) % 4 == 0 && n != 3) {
                    n++;
                }else {
                    n--;
                }
            }
            res++;
        }
        return res;
    }
}
