package meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class treatString {
    public static List<String> strs = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        for (int i = 0; i < k; i++) {
            strs.add(in.next());
        }
        for (int i = 0; i < n; i++) {
            String s = in.next();
            if (s.charAt(0) == '?') {
                int res = helper(s.substring(1));
                System.out.println(res);
            } else {
                if (s.charAt(0) == '+') {
                    strs.add(strs.get(Integer.parseInt(s.substring(1))));
                    printS();
                } else {
                    strs.remove(strs.get(Integer.parseInt(s.substring(1))));
                }
            }
        }
    }

    public static int helper(String s) {
        int res = 0;
        for (int i = 0; i < strs.size(); i++) {
            String str = strs.get(i);
            int start = 0;
            while (start < s.length() && s.indexOf(str, start) >= 0) {
                res++;
                start = s.indexOf(str, start);
                start++;
            }
        }
        return res;
    }

    public static void printS() {
        for (int i = 0; i < strs.size(); i++) {
            System.out.println(strs.get(i));
        }
    }
}
