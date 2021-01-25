import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            long n = in.nextLong();
            long k = in.nextLong();
            long d1 = in.nextLong();
            long d2 = in.nextLong();
            boolean res = helper(n, k, d1, d2);
            if (res) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    public static boolean helper(long n, long k, long d1, long d2) {
        if (n % 3 != 0 || n - k < d1 + d2) return false;

        // 1 > 2 > 3
        long m1 = k + 2 * d1 + d2;
        //1 > 3 > 2 || 3 > 1 > 2
        long m2 = 0;
        if (d1 >= d2) {
            m2 = k + 2 * d1 - d2;
        } else {
            m2 = k + 2 * d2 - d1;
        }
        long m2m = k + 2 * d1 - d2;

        // 2 > 1 > 3 || 2 > 3 > 1
        long m3 = k + d1 + d2;
        long m3m = k + d2 - 2 * d1;

        // 3 > 2 > 1
        long m4 = k + 2 * d2 + d1;
        long m4m = k - 2 * d1 - d2;

        if ((m1 <= n && m1 % 3 == 0 && m1 >= 0)
                || (m2 <= n && m2 % 3 == 0 && m2 >= 0 && m2m >=0 && m2m % 3 == 0)
                || (m3 <= n && m3 % 3 == 0 && m3 >= 0 && m3m >=0 && m3m % 3 == 0)
                || (m4 <= n && m4 % 3 == 0 && m4 >= 0 && m4m >=0 && m4m % 3 == 0)) {
            return true;
        }
        return false;
    }
}