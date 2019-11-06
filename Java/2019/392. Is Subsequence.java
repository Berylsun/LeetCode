//n, 1
class Solution {
    public boolean isSubsequence(String s, String t) {
        for (int i = 0, j = 0; i < s.length(); i++) {
            while (j < t.length() && t.charAt(j) != s.charAt(i)) {
                j++;
            }
            j++;
            if (j > t.length()) {
                return false;
            }
        }
        return true;
    }
}


public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) return true;
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) i++;
            j++;
        }
        return i == s.length();
    }
