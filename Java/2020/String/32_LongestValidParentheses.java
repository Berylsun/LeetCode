class Solution {
    /**
     * O(n)
     * O(n)
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int res = 0;
        int start = -1;
        int i = 0;
        Stack<Integer> stack = new Stack<>();

        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    start = i;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        res = Math.max(res, i - start);
                    } else {
                        res = Math.max(res, i - stack.peek());
                    }
                }
            }
            i++;
        }

        return res;
    }
}