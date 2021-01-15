/**
 * O(n^2)
 * O(1)
 */
class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (Math.abs(m - n) >= 2) return false;
        int i = 0;
        while (i < m && i < n) {
            if (s.charAt(i) == t.charAt(i)) {
                i++;
            } else {
                StringBuilder sb = new StringBuilder();
                if (m < n) {
                    sb.append(s.substring(0, i) + t.charAt(i) + s.substring(i));
                } else if (m > n) {
                    sb.append(s.substring(0, i) + s.substring(i + 1));
                } else {
                    sb.append(s.substring(0, i) + t.charAt(i) + s.substring(i + 1));
                }
                return t.equals(sb.toString());
            }
        }
        return m != n;
    }
}