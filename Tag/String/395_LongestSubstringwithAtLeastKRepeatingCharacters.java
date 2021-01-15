class Solution {
    /**
     * O(n)
     * O(1)
     * @param s
     * @param k
     * @return
     */
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        int res = 0;
        for (int i = 1; i <= 26; i++) {
            res = Math.max(res, helper(s, k, i));
        }
        return res;
    }

    public int helper(String s, int k, int target) {
        int end = 0;
        int start = 0;
        int uniqueNum = 0;
        int nolessthanK = 0;
        int[] count = new int[128];
        int res = 0;
        while (end < s.length()) {
            if (count[s.charAt(end)]++ == 0) uniqueNum++;
            if (count[s.charAt(end)] == k) nolessthanK++;
            end++;
            while (uniqueNum > target) {
                if (count[s.charAt(start)]-- == k) nolessthanK--;
                if (count[s.charAt(start)] == 0) uniqueNum--;
                start++;
            }
            if (uniqueNum == target && target == nolessthanK) {
                res = Math.max(res, end - start);
            }
        }
        return res;
    }
}