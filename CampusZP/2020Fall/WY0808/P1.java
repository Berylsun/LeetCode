package WY;
//最多素数
import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        long n = in.nextLong();
        long res = 0;
        for (int i = 0; i < n; i++) {
            long temp = in.nextLong();
            res += temp / 2;
        }
        System.out.println(res);
    }
}
