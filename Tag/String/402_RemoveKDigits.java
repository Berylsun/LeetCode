class Solution {
    /**
     * O(n)
     * O(n)
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {
        if (num.length() <= k) return "0";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                k--;
                stack.pop();
            }
            stack.push(num.charAt(i));
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        String res = sb.reverse().toString();
        int idx = 0;
        while (idx < res.length() && res.charAt(idx) == '0') {
            idx++;
        }
        res = res.substring(idx);
        if (res.equals("")) return "0";  // res == "" will make mistake!!!!!
        return res;
    }
}