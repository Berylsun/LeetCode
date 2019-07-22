//n, n
class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
            }else if (c == '[') {
                stack.push(']');
            }else if (c == '{') {
                stack.push('}');
            }else {
                if (stack.isEmpty() || stack.peek() != c) {
                    return false;
                }else {
                    stack.pop();
                }
            }
            i++;
        }
        return stack.isEmpty();
    }
}
