//n, n
class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i < num + 1; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }
        
        return res;
    }
}

class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i < num + 1; i++) {
            int cur = i;
            while (cur != 0) {
                res[i]++;
                cur = cur & (cur - 1);
            }
        }
        
        return res;
    }
}
