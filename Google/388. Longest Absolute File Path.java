//O(n), n
//level -> stack

class Solution {
    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) return 0;
        int len = 0;
        int res = 0;
        
        Stack<Integer> stack = new Stack<>();
        String[] paths = input.split("\n");
        
        for (String s : paths) {
            int level = s.lastIndexOf("\t"); //find \t
            while (level + 1 < stack.size()) stack.pop(); //find parent
            int curlen = s.length() - level - 1; // real str len
            
            //+1: '\'
            if (stack.isEmpty()) {
                len = curlen + 1;
                stack.push(len);
            }else {
                len = stack.peek() + curlen + 1;
                stack.push(len);
            }
            
            if (s.contains(".")) {
                res = Math.max(res, len - 1);
            }
            
        }
        
        return res;
    }
}
