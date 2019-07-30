//n, 1
class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            while (i <= j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i <= j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (i <= j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }else {
                i++;
                j--;
            }
        }
        return true;
    }
}
