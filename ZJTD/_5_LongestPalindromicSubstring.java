class Solution {
    String res;

    /**
     * O(n^2)
     * O(1)
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        res = "";
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i);
            helper(s, i, i + 1);
        }
        return res;
    }

    public void helper(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        if (r - l - 1 > res.length()) {
            res = s.substring(l + 1, r);
        }
    }
}