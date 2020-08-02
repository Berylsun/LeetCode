class Solution {
    /**
     * O(n)
     * O(1)
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        s = s.trim();
        if (s == null || s.length() == 0) return false;
        boolean numSeen = false;
        boolean eSeen = false;
        boolean pointSeen = false;
        boolean numAfterE = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                numSeen = true;
                numAfterE = true;
            } else if (c == '+' || c == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            }
            else if (c == '.') {
                if (pointSeen || eSeen) {
                    return false;
                }
                pointSeen = true;
            } else if (c == 'e') {
                if (!numSeen || eSeen) {
                    return false;
                }
                eSeen = true;
                numAfterE = false;
            } else {
                return false;
            }
        }
        return numSeen && numAfterE;
    }
}