//n, n
class Solution {
    public String simplifyPath(String path) {
        String[] paths = path.split("/+");
        Stack<String> stack = new Stack<>();
        for (String s : paths) {
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }                
            }else if (s.equals(".") || s.equals("")) {
                continue;
            }else {
                stack.push(s);
            }            
        }
        
        String res = "";
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }
        if (res.equals("")) {
            res += "/";
        }
        
        return res;
    }
}
