//nlogn, n
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int res = 0;
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        
        int[] dp = new int[envelopes.length];
        
        for (int[] envelope : envelopes) {
            int i = binarySearch(dp, 0, res, envelope[1]);
            dp[i] = envelope[1];
            if (i == res) res++;
        }
        
        return res;
    }
    
    public int binarySearch(int[] dp, int start, int end, int target) {
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (dp[mid] == target) {
                return mid;
            }else if (dp[mid] < target) {
                start = mid;
            }else {
                end = mid;
            }
        }
        if (dp[start] >= target) return start;
        return end;
    }
}
