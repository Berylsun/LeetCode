package AQY;

import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n =  in.nextLong();
        long num2 = 0;
        long num5 = 0;
        for (long i = 1; i <= n; i++) {
            long temp = i;
            while (temp % 2 == 0) {
                num2++;
                temp /= 2;
            }
            while (temp % 5 == 0) {
                num5++;
                temp /= 5;
            }
        }
        System.out.println(Math.min(num2, num5));
    }
}
