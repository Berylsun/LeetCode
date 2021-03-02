class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        helper(n, n, "");
        return res;
    }

    public void helper(int l, int r, String s) {
        if (l > r) return;
        if (l == 0 && r == 0) {
            res.add(s);
            return;
        }
        if (l > 0) {
            helper(l - 1, r, s + "(");
        }
        helper(l, r - 1, s + ")");
    }
}