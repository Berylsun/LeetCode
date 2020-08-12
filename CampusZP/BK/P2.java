package BK;
// 质数
import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long t = in.nextLong();
        for (long i = 0; i < t; i++) {
            long n = in.nextLong();
            long m = in.nextLong();
            if (m * n == 1) {
                System.out.println(0);
                continue;
            }
            for (long j = 2; j <= m * n; j++) {
                if (m * n % j == 0) {
                    System.out.println(j);
                    break;
                }
            }
        }
    }
}
