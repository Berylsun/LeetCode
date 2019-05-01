class Solution {
    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        String[] str = input.split("\n");
        stack.push(0); //!!!!!!
        int len = 0;
        int res = 0;
        for (String s : str) {
            int level = s.lastIndexOf("\t") + 1;
            while (level < stack.size() - 1) {
                stack.pop();
            }
            len = stack.peek() + s.length() - level + 1;
            stack.push (len);
            if (s.contains(".")) {
                res = Math.max(res, len - 1);
            }
        }
        return res;
    }
}
