//时间复杂度是O(m*n)，因为在最坏情况下： s = "aaaaaaaaaaaaaaaaaaaa" p = "*aaaaaaaaaaaaaaaaaab" , 1
class Solution {
    public boolean isMatch(String s, String p) {
        int sp = 0;
        int pp = 0;
        int match = 0;
        int star = -1;
        while (sp < s.length()) {
            if (pp < p.length() && (s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '?')) {
                pp++;
                sp++;
            }else if (pp < p.length() && p.charAt(pp) == '*') {
                match = sp;
                star = pp;
                pp++;
            }else if (star != -1) {
                match++;
                sp = match;
                pp = star + 1; //最后还得回来
            }else {
                return false;
            }
        }
        while (pp < p.length() && p.charAt(pp) == '*') {
            pp++;
        }
        return pp == p.length();
    }
}
