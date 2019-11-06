//n, n
class Solution {
    public String decodeString(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            int count = 0;
            if (Character.isDigit(s.charAt(idx))) {
                while ( idx < s.length() && Character.isDigit(s.charAt(idx))) {
                    count = count * 10 + s.charAt(idx) - '0';
                    idx++;
                }
                countStack.push(count);
            }else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            }else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder();
                temp.append(resStack.pop());
                int time = countStack.pop();
                for (int i = 0; i < time; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
                
            }else {
                res += s.charAt(idx);
                idx++;
            }   
        }
        return res;
    }
}
