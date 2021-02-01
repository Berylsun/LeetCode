class Solution {
    /**
     * O(n)
     * O(1)
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            char c1 = s.charAt(l);
            char c2 = s.charAt(r);
            if (!Character.isLetterOrDigit(c1)) {
                l++;
            } else if (!Character.isLetterOrDigit(c2)) {
                r--;
            } else {
                if (Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
                    return false;
                }
                l++;
                r--;
            }
        }
        return true;
    }
}