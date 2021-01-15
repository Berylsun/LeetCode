package DD;
import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n < 2) {
            System.out.println(n);
            return;
        }
        long[] nums = new long[n * n];
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i < n * n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        int scol = 0;
        int ecol = n - 1;
        int srow = 0;
        int erow = n - 1;
        long[][] res = new long[n][n];
        int idx = n * n - 1;
        while (idx >= 0) {
            for (int i = scol; i <= ecol && idx >= 0; i++) {
                res[srow][i] = nums[idx--];
            }
            srow++;
            for (int i = srow; i <= erow && idx >= 0; i++) {
                res[i][ecol] = nums[idx--];
            }
            ecol--;

            for (int i = ecol; i >= scol && idx >= 0; i--) {
                res[erow][i] = nums[idx--];
            }
            erow--;

            for (int i = erow; i >= srow && idx >= 0; i--) {
                res[i][scol] = nums[idx--];
            }
            scol++;
        }

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(res[i][j] + " ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}
