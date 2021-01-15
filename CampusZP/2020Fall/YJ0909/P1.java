package YJ0909;

import java.util.Scanner;
import java.util.Stack;

public class P1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (int i = 0 ; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '"') {
                count++;
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '(') {
                stack.push(')');
            } else if (c == '}' || c == ']' || c== ')') {
                if (stack.isEmpty() || stack.pop() != c) {
                    System.out.println("false");
                    return;
                }
            }
        }
        if (stack.isEmpty() && count % 2 == 0) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
