class Solution {
    /**
     * O(n)
     * O(n)
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        int i = 0;
        Stack<Character> stack = new Stack<>();
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return false;
                }
                stack.pop();
            } else if (c == '}') {
                if (stack.isEmpty() || stack.peek() != '{') {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
            i++;
        }
        return stack.isEmpty();
    }
}