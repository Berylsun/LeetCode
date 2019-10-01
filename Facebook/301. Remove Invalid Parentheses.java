//unknown, n
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null) return res;
        
        helper(res, s, 0, 0, new char[] {'(', ')'});
        
        return res;
    }
    
    public void helper(List<String> res, String s, int last_i, int last_j, char[] pair) {
        //( > )
        int count = 0;
        for (int i = last_i; i < s.length(); i++) {
            if (s.charAt(i) == pair[0]) count++;
            if (s.charAt(i) == pair[1]) count--;
            if (count >= 0) continue;
            for (int j = last_j; j <= i; j++) {
                if (s.charAt(j) == pair[1] && (j == last_j || s.charAt(j - 1) != pair[1])) {
                    helper(res, s.substring(0, j) + s.substring(j + 1), i, j, pair);
                }
            }
            return;
        }
        
        //) > (
        String reverse = new StringBuilder(s).reverse().toString();
        if (pair[0] == '(') {
            helper(res, reverse, 0, 0, new char[]{')', '('}); //must be at the beginning
        }else {
            res.add(reverse);
        }
        
    }
}
