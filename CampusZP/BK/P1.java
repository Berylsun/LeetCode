package BK;
// 回文
import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.next());
        String s = in.next();
        int i = 0;
        int j = n - 1;
        int res = 0;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                res++;
            }
            i++;
            j--;
        }
        System.out.println(res);
    }
}
