//n^2, 1
class Solution {
    String res = "";
    public String longestPalindrome(String s) {
        // from center to two sides ~
        if (s == null || s.length() == 0) return s;
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i);
            helper(s, i, i + 1);
        }
        return res;
    }
    
    public void helper(String s, int i, int j) {
        if (j >= s.length()) return;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if (res.length() < j - i - 1) {
            res = s.substring(i + 1, j);
        }
    }
}
