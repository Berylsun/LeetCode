class Solution {
    /**
     * O(k)
     * O(1)
     * @param cardPoints
     * @param k
     * @return
     */
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int start = n - k;
        int temp = start;
        int win = 0;
        int res = 0;
        for (int i = start; i < n + k; i++) {
            win += cardPoints[i % n];
            if (i >= n) {
                win -= cardPoints[temp++];
            }
            res = Math.max(win, res);
        }
        return res;
    }
}