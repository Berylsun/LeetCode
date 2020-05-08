class Solution {
    /**
     * O(n^2)
     * O(1)
     * @param s
     * @return
     */
    public String shortestPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        int end = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                i = 0;
                end--;
                j = end;
            }
        }
        return new StringBuilder(s.substring(end + 1)).reverse().toString() + s;
    }
}