package meituan;

import java.util.Scanner;

public class nkpow {
    private static long getDay(long x, long k) {
        int day = 0;
        int base = 1;
        while (base <= x) {
            day ++;
            base *= k;
        }
        return day;
    }
    private static boolean single(long n, long k, long x) {
        long days = getDay(x, k);
        long res = 0;
        long base = 1;
        for (long i = 0; i < days; ++ i) {
            res += (x / base);
            base *= k;
        }
        return res >= n;
    }
    private static void solution(long n, long k) {
        if (n == 1) {
            System.out.println(1);
            return;
        }
        long left = 2, right = n;
        if (single(n, k, left)) {
            System.out.println(2);
            return;
        }
        while (left < right) {
            if (left + 1 == right) {
                if (single(n, k, left)) {
                    System.out.println(left);
                } else {
                    System.out.println(right);
                }
                return;
            }
            long mid = (left + right) / 2;
            if (single(n, k, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        System.out.println(left);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), k = scanner.nextInt();
        solution(n, k);
    }
}
