class Solution {
    /**
     * unknown
     * O(n)
     */
    List<String> res = new ArrayList<>();
    public List<String> removeInvalidParentheses(String s) {
        if (s == null) return res;
        helper(s, 0, 0, new char[]{'(', ')'});
        return res;
    }

    public void helper(String s, int li, int lj, char[] pairs) {
        int count = 0;
        for (int i = li; i < s.length(); i++) {
            if (s.charAt(i) == pairs[0]) {
                count++;
            }
            if (s.charAt(i) == pairs[1]) {
                count--;
            }
            if (count >= 0) continue;
            for (int j = lj; j <= i; j++) {
                if (s.charAt(j) == pairs[1] && (j == lj || s.charAt(j - 1) != pairs[1])) {
                    helper(s.substring(0, j) + s.substring(j + 1), i, j, pairs);
                }
            }
            return;
        }
        String sb = new StringBuilder(s).reverse().toString();
        if (pairs[0] == '(') {
            helper(sb, 0, 0, new char[]{')', '('});
        } else {
            res.add(sb);
        }
    }
}