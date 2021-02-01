import java.util.*;

public class Solution {
    /**
     * O(mn)
     * O(mn)
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.next();
            String[] strs = s.split(",");
            String a = strs[0];
            String b = strs[1];
            int[][] dp = new int[a.length() + 1][b.length() + 1];
            for (int i = 0; i <= a.length(); i++) {
                dp[i][0] = i;
            }
            for (int j = 0; j <= b.length(); j++) {
                dp[0][j] = j;
            }

            for (int i = 1; i <= a.length(); i++) {
                for (int j = 1; j <= b.length(); j++) {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                    if (a.charAt(i - 1) == b.charAt(j - 1)) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                    }

                }
            }
            System.out.println(dp[a.length()][b.length()]);
        }
    }
}