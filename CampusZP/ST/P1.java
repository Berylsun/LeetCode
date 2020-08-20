package ST;

import java.util.LinkedList;
import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        LinkedList<StringBuilder> list = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'G') {
                list.addLast(new StringBuilder("G"));
            } else if (c == 'o') {
                for (StringBuilder temp : list) {
                    if (temp.toString().equals("G") || temp.toString().equals("Go")) {
                        temp.append("o");
                        break;
                    }
                }
            } else if (c == 'd') {
                if (list.size() != 0 && list.get(0).toString().equals("Goo")) {
                    res++;
                    list.removeFirst();
                }
            }
        }
        System.out.println(res);
    }
}
