class Solution {
    /**
     * O(n^2)
     * O(n^2)
     * @param s
     * @return
     */
    public int minCut(String s) {
        int len = s.length();
        boolean[][] isPalindrome = new boolean[len][len];  // from j to i
        int[] cut = new int[len];
        for (int i = 0; i < s.length(); i++) {
            cut[i] = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || isPalindrome[j + 1][i - 1])) { // !!! i - j < 2
                    isPalindrome[j][i] = true;
                    cut[i] = j == 0 ? 0 : Math.min(cut[i], cut[j - 1] + 1);
                }
            }
        }
        return cut[len - 1];
    }
}