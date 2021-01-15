class Solution {
    /**
     * O(2^n)
     * O(n)
     */
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        helper(n, n, "");
        return res;
    }
    public void helper(int l, int r, String s) {
        if (l == 0 && r == 0){
            res.add(s);
            return;
        }
        if (l > r) return;
        if (l < 0 || r < 0) return;
        helper(l - 1, r, s + '(');
        helper(l, r - 1, s + ')');
    }
}