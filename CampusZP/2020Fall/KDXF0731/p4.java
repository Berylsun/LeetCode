package KDXF0731;
//字符串提取整数：考虑负数和0在最前面

import java.util.Scanner;

public class p4 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        String s = in.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (sb.length() == 0 && c == '-') {
                sb.append(c);
            }
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
    }
}
