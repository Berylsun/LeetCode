class Solution {
    /**
     * O(n)
     * O(1)
     * LC8
     * @param str
     * @return
     */
    public int strToInt(String str) {
        str = str.trim();
        if (str == null || str.length() == 0) return 0;
        long res = 0;
        int sign = 1;
        int start = 0;
        if (str.charAt(0) == '-') {
            sign = -1;
            start++;
        }
        if (str.charAt(0) == '+') {
            start++;
        }
        for (int i = start; i < str.length(); i++) {
            int cur = str.charAt(i) - '0';
            if (cur >= 0 && cur <= 9) {
                res = res * 10 + cur;
                if (sign == -1 && sign * res <= Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
                if (sign == 1 && res >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
            } else {
                break;
            }
        }

        return sign * (int)res;
    }
}