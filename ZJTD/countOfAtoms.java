import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.next();
            String ans = helper(s);
            System.out.println(ans);
        }
    }

    /**
     * Similar 726
     * @param s
     * @return
     */
    public static String helper(String s) {
        int n = s.length();
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new TreeMap<>());
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[') {
                stack.push(new TreeMap<>());
                i++;
            } else if (s.charAt(i) == ')' || s.charAt(i) == ']') {
                int start = ++i;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    i++;
                }
                int mul = i > start ? Integer.parseInt(s.substring(start, i)) : 1;
                Map<String, Integer> top = stack.pop();
                for (String str : top.keySet()) {
                    int v = top.get(str);
                    stack.peek().put(str, stack.peek().getOrDefault(str, 0) + v * mul);
                }
            } else {
                int start = i++;
                while (i < n && Character.isLowerCase(s.charAt(i))) {
                    i++;
                }
                String name = s.substring(start, i);
                start = i;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    i++;
                }
                int mul = i > start ? Integer.parseInt(s.substring(start, i)) : 1;
                stack.peek().put(name, stack.peek().getOrDefault(name, 0) + mul);
            }
        }
        StringBuilder res = new StringBuilder();
        for (String str : stack.peek().keySet()) {
            int mul = stack.peek().get(str);
            res.append(str + "" + mul);
        }
        return res.toString();
    }
}