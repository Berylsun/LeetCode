class Solution {
    /**
     * O(n)
     * O(1)
     * @param s
     * @param k
     * @return
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int res = 0;
        int[] count = new int[128];
        int num = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (count[s.charAt(i)]++ == 0) num++;
            if (num > k) {
                while (--count[s.charAt(j)] > 0) {
                    j++;
                }
                j++;
                num--;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}