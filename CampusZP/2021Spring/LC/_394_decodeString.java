class Solution {
    /**
     * O(n)
     * O(n)
     * @param s
     * @return
     */
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Integer> nstack = new Stack<>();
        Stack<String> sstack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int num = 0;
                while (Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                nstack.push(num);
            } else if (s.charAt(i) == '[') {
                sstack.push(res.toString());
                res = new StringBuilder();
                i++;
            } else if (s.charAt(i) == ']') {
                StringBuilder sb = new StringBuilder(sstack.pop());
                int time = nstack.pop();
                for (int k = 0; k < time; k++) {
                    sb.append(res.toString());
                }
                res = sb;
                i++;
            } else {
                res.append(s.charAt(i));
                i++;
            }
        }
        return res.toString();
    }
}