//n, n
class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }else {
                if (stack.isEmpty()) {
                    start = i;
                }else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        res = Math.max(res, i - start);
                    }else {
                        res = Math.max(res, i - stack.peek());
                    }
                }
            }
        }
        return res;
    }
}
