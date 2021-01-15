class Solution {
    /**
     * O(n)
     * O(1)
     * toLowerCase !!!
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            } else if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            } else {
                char l = Character.toLowerCase(s.charAt(i));
                char r = Character.toLowerCase(s.charAt(j));
                if (l == r) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}