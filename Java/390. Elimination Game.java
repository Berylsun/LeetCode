class Solution {
    public int lastRemaining(int n) {
        boolean left = true;
        int step = 1;
        int res = 1;
        int remain = n;
        while (remain / 2 != 0) {
            if (left || remain % 2 == 1) {
                res += step;
            }
            step *= 2;
            remain /= 2;
            left = !left;
        }
        return res;
    }
}
