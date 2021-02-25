class Solution {
    /**
     * O(n)
     * O(1)
     * @param values
     * @return
     */
    public int maxScoreSightseeingPair(int[] values) {
        if (values == null || values.length == 0) return 0;
        int len = values.length;
        int res = Integer.MIN_VALUE;
        int mx = values[0] + 0;
        for (int j = 1; j < len; j++) {
            res = Math.max(res, mx + values[j] - j);
            mx = Math.max(mx, values[j] + j);
        }
        return res;
    }
}