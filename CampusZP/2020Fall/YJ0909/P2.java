package YJ0909;

import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count2 = 0;
        int count5 = 0;
        for (int i = 1; i <= n; i++) {
            int[] temp = findZero(i);
            count2 += temp[0];
            count5 += temp[1];
        }
        System.out.println(Math.min(count2, count5));
    }

    private static int[] findZero(int n) {
        int[] res = new int[2];
        while (n % 2 == 0) {
            res[0]++;
            n /= 2;
        }
        while (n % 5 == 0) {
            res[1]++;
            n /= 5;
        }
        return res;
    }
}
