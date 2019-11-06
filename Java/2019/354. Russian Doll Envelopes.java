class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] dp = new int[envelopes.length];
        int i = 0;
        int res = 0;
        for (int[] envelop : envelopes) {
            i = binarySearch(dp, 0, res, envelop[1]);
            dp[i] = envelop[1];
            if (i == res) res++;
        }
        return res;
    }
    
    public int binarySearch(int[] dp, int i, int j, int target) {
        while (i < j) {
            int mid = (j - i)/ 2 + i;
            if (dp[mid] < target) {
                i = mid + 1;
            }else {
                j = mid;
            }
        }
        return i;
    }
}
