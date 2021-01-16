class Solution {
    /**
     * O(n)
     * O(n)
     * @param num
     * @return
     */
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= s.length(); i ++){
            String temp = s.substring(i-2, i);
            if(temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0)
                dp[i] = dp[i-1] + dp[i-2];
            else
                dp[i] = dp[i-1];
        }
        return dp[s.length()];
    }
    /**
     * O(n)
     * O(n)
     * @param num
     * @return
     */
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int a = 1;
        int b = 1;
        for (int i = 2 ; i <= str.length(); i++) {
            String temp = str.substring(i - 2, i);
            int c = a;
            if (temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0) {
                c = a + b;
            }
            b = a;
            a = c;
        }
        return a;
    }

    public int translateNum(int num) {
        if (num <= 9) return 1;
        int m = num % 100;
        if (m <= 9 || m > 25) {
            return translateNum(num / 10);
        }
        return translateNum(num / 10) + translateNum(num / 100);
    }
}