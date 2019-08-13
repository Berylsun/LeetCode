//n, 1
class Solution {
    public int myAtoi(String str) {
        long res = 0;
        str = str.trim();
        if (str == null || str.length() == 0) return 0;
        char firstChar = str.charAt(0);
        int sign = 1;
        int start = 0;
        
        if (firstChar == '+') {
            start++;
        }else if (firstChar == '-') {
            start++;
            sign = -1;
        }
        
        for (int i = start; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return sign * (int)res;
            }
            res = res * 10 + str.charAt(i) - '0';
            if (sign * res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if (sign * res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        }
        
        return sign * (int)res;
    }
}
