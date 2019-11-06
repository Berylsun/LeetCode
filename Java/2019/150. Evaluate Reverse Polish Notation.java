class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+") ) {
                stack.push(stack.pop() + stack.pop());
            }else if (s.equals("-") ) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            }else if (s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            }else if (s.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b/a);
            }else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}



String转换为int型
//convert str(String) to i(int)
String str;
int i = Integer.parseInt(str);

int型转换为String
//conver i(int) to str(String)
int i;
String str = i.toString();

//convert i(int) to j(Integer)
int i;
Integer j = Integer.valueOf(i);

//convert t(Integer) to n (int)
Integer t;
int n = t.intValue();
