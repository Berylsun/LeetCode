package AQY;

import java.util.HashSet;
import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        HashSet<String> set = new HashSet<>();
        int m = 0;
        int n = 0;
        set.add(m + "&" + n);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            String sn = "";
            if (c == 'N') {
                sn = (m - 1) + "&" + n;
                m = m - 1;
            } else if (c == 'S') {
                sn = (m + 1) + "&" + n;
                m = m + 1;
            } else if (c == 'W') {
                sn = m + "&" + (n - 1);
                n = n - 1;
            }else if (c == 'E') {
                sn = m + "&" + (n + 1);
                n = n + 1;
            } else {
                continue;
            }
            if (!set.add(sn)) {
                System.out.println("True");
                return;
            }
        }
        System.out.println("False");
    }
}
