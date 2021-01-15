class Solution {
    /**
     * O(n)
     * O(n)
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        if (n < 1) return 0;
        int[] res = new int[n];
        int idx2 = 0;
        int idx3 = 0;
        int idx5 = 0;
        res[0] = 1;
        for (int i = 1 ; i < n; i++) {
            res[i] = Math.min(res[idx2] * 2, Math.min(res[idx3] * 3, res[idx5] * 5));
            // when 2 * 3 == 6 == 3 * 2, we should both add idx3 and idx2
            if (res[i] == res[idx2] * 2) idx2++;
            if (res[i] == res[idx3] * 3) idx3++;
            if (res[i] == res[idx5] * 5) idx5++;
        }
        return res[n - 1];
    }
}