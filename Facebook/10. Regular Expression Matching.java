class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        int len1 = s.length();
        int len2 = p.length();
        
        dp[0][0] = true;
        for (int i = 0; i < len2; i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                }else {
                    if (p.charAt(j) == '*') {
                        if (s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                            //0, 1, many
                            dp[i + 1][j + 1] = dp[i + 1][j - 1] || dp[i + 1][j] || dp[i][j + 1];
                        }else {
                            dp[i + 1][j + 1] = dp[i + 1][j - 1]; //0
                        }
                    }
                }
            }
        }
        
        return dp[len1][len2];
    }
}
