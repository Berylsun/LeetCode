class Solution {
    /**
     * O(n)
     * O(n)
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        if (s == null || s.length() == 0) return s;
        n %= s.length();
        StringBuilder sb = new StringBuilder(s.substring(n));
        sb.append(s.substring(0, n));
        return sb.toString();
    }
}