//n, n
class Solution {
    public String simplifyPath(String path) {
        String[] str = path.split("/+");
        Stack<String> stack = new Stack<>();
        for (String s : str) {
            if (s.equals("..")) {
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else if (!s.equals(".") && !s.equals("")) {
                stack.push(s);
            }            
        }
        String res = "";
        while(!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }
        if (res.length() == 0) {
            return "/";
        }
        return res;
    }
}
