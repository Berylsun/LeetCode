//n,n
class Solution {
    public int calculate(String s) {
        char sign = '+';
        int res = 0;
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                stack.push(num);
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1) {
                //if (sign == '+') stack.push(stack.pop());
                if (sign == '-') stack.push(-stack.pop());
                if (sign == '*') stack.push(stack.pop() * stack.pop());
                if (sign == '/')  {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b / a);
                }
                sign = s.charAt(i);
            }
        }
        
        for (int i : stack) {
            res += i;
        }
        
        return res;
    }
}

//n, 1
class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        s = s.trim().replaceAll(" +", "");
        int res = 0;
        int prev = 0;
        int cur = 0;
        int i = 0;
        char sign = '+';
        
        while (i < s.length()) {
            cur = 0;
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                cur = cur * 10 + s.charAt(i) - '0';
                i++;
            }
            
            if (sign == '+') {
                res += prev;
                prev = cur;
            }else if (sign == '-') {
                res += prev;
                prev = -cur;
            }else if (sign == '*') {
                prev = prev * cur;
            }else if (sign == '/') {
                prev = prev / cur;
            }
            
            if (i < s.length()) {
                sign = s.charAt(i);
                i++;
            }
        }
        
        return res + prev;
    }
}
