class Solution {
    /**
     * O(10^n)
     * O(1)
     * @param n
     * @return
     */
    public int[] printNumbers(int n) {
        int num = (int)Math.pow(10, n) - 1;
        int[] res = new int[num];
        for (int i = 0; i < num; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}