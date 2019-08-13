//m * n, 1
class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        int star = -1;
        int match = -1;
        while (i < s.length()) {
            if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            }else if (j < p.length() && p.charAt(j) == '*') {
                star = j;
                match = i;
                j++;
            }else if (star != -1) {
                match++;
                i = match;
                j = star + 1;                
            }else return false;
        }
        
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }
        
        return j == p.length();
    }
}
