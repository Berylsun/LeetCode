//n, n
class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        int start = -1;
        int res = 0;
        Stack<Integer> stack = new Stack<>(); //must be Integer instead of Character   OR ("()(())") will be wrong!!!
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
                        res = Math.max(res, i - stack.peek()); // now, stack.peek() is pre-'(', because cur-'('has been delete
                    }
                }
            }
        }
        return res;
    }
}
