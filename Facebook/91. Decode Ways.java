//n, n
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        
        for (int i = 2; i <= s.length(); i++) {
            int val1 = Integer.valueOf(s.substring(i - 1, i));
            int val2 = Integer.valueOf(s.substring(i - 2, i));
            if (val1 <= 9 && val1 >= 1) { // != 0
                dp[i] += dp[i - 1];
            }
            if (val2 <= 26 && val2 >= 10) {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[s.length()];
    }
}

//n, 1
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        
        int c1 = 1;
        int c2 = 1;
        
        for (int i = 2; i <= s.length(); i++) {
            int val1 = Integer.valueOf(s.substring(i - 1, i));
            int val2 = Integer.valueOf(s.substring(i - 2, i));
            if (val1 == 0) {
                c1 = 0;
            }
            if (val2 <= 26 && val2 >= 10) {
                //dp[i] += dp[i - 2];
                c1 = c1 + c2;
                c2 = c1 - c2; // c2 = pre_c1;
            }else {
                c2 = c1;
            }
        }
        
        return c1;
    }
}

    public int numDecodings2(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int c1 = 1;
        int c2 = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                c1 = 0;
            }
            if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) <= '6') {
                c1 = c1 + c2;
                c2 = c1 - c2;
            } else {
                c2 = c1;
            }
        }
        return c1;
    }
