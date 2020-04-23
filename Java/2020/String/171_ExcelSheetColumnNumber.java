class Solution {
    /**
     * O(n)
     * O(1)
     * @param s
     * @return
     */
    public int titleToNumber(String s) {
        int res = 0;
        if (s == null || s.length() == 0) return res;
        for (int i = 0; i < s.length(); i++) {
            res = 26 * res + (s.charAt(i) - 'A') + 1;
        }
        return res;
    }
}