package bilibili;

import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        String str = "aaabbaaac" ;
        int res = GetFragment(str);
        System.out.println(res);
    }

    public static int GetFragment (String str) {
        // write code here
        if (str == null || str.length() == 0) return 0;
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                count++;
            }
        }
        return str.length() / count;
    }
}
