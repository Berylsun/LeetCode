//n, 1
class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        int res = 0;
        for (int i = 1; i <= 26; i++) {
            res = Math.max(res, helper(s, k, i));
        }
        return res;
    }
    
    public int helper(String s, int k, int numTarget) {
        int res = 0;
        int[] count = new int[128];
        int numUnique = 0;
        int numNoLessThanK = 0;
        int start = 0, end = 0;
        while (end < s.length()) {
            if (count[s.charAt(end)]++ == 0) numUnique++;
            if (count[s.charAt(end++)] == k) numNoLessThanK++;
            
            while (numUnique > numTarget) {
                if (count[s.charAt(start)]-- == k) numNoLessThanK--;
                if (count[s.charAt(start++)] == 0) numUnique--;
            }
            
            if (numUnique == numTarget && numUnique == numNoLessThanK) {
                res = Math.max(res, end - start);
            }
        }
        return res;
    }
}
