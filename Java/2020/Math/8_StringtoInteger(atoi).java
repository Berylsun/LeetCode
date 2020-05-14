class Solution {
    /**
     * O(n)
     * O(1)
     * Should not use Long.parseInt() because we don't whether the str.length is bigger than long;
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        str = str.trim();
        int idx = 0;
        int sign = 1;
        long res = 0;
        if (idx < str.length() && (str.charAt(idx) == '-' || str.charAt(idx) == '+')) {
            if (str.charAt(idx) == '-') {
                sign = -1;
            }
            idx++;
        }
        for (int i = idx; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return (int)res * sign; // * sign !!!
            }
            res = res * 10 + str.charAt(i) - '0';
            if (res * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;  // * sign !!!
            if (res * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        }
        return (int) res * sign; // * sign !!!
    }
}