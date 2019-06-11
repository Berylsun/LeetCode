class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            }
            if (s.charAt(i) == '{') {
                stack.push('{');
            }
            if (s.charAt(i) == '[') {
                stack.push('[');
            }
            if (s.charAt(i) == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }else{
                    stack.push(')');
                }
            }
            if (s.charAt(i) == ']') {                
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                }else {
                    stack.push(']');
                }
            }
            if (s.charAt(i) == '}') {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                }else {
                    stack.push('}');
                }
            }
        }
        return stack.isEmpty();
    }
    
    
    
    
    public static boolean isValid2(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (Character ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '[') {
                stack.push(']');
            } else if (ch == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty() || stack.pop() != ch) {  //right part more than left part
                    return false;
                }
            }
        }
        return stack.isEmpty(); //left part more than right part
    }
}



