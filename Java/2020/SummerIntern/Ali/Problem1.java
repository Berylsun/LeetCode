import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            int res = helper(n, m, a, b);
            System.out.println(res);
        }
    }

    public static int helper(int n, int m, int a, int b) {
        if (b >= m) {
            return a > n ? 0 : m;
        }
        if (a > n) {
            return 0;
        }
        int res = n * b / a;
        return res > m ? m : res;
    }
}
