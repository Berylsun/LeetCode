//n^2, n
in front of!!!
class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        int i = 0;
        int j = s.length() - 1;
        int end = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            }else {
                i = 0;
                end--;
                j = end;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        return sb.append(s.substring(end + 1)).reverse().append(s).toString();
    }
}
