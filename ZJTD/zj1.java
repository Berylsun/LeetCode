import java.util.Scanner;

public class zj1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = in.nextInt() - 1;
        }
        int count = solution2(p);
        System.out.println(count);
    }

    public static int solution1(int[] p) {
        int n = p.length;
        boolean[] odd = new boolean[n];
        odd[0] = true;
        int cur = 0;
        int count = 0;
        while (cur != n) {
            if (odd[cur]) {
                cur = p[cur];
                odd[cur] = !odd[cur];
            } else {
                cur++;
                if (cur < n) {
                    odd[cur] = !odd[cur];
                }
            }
            count++;
            count %= 1000000007;
        }
        return count;
    }

    public static int solution2(int[] p) {
        // https://blog.csdn.net/flushhip/article/details/79458502
        //dp[i] = 2 * dp[i - 1] - dp[p[i - 1]] + 2
        int n = p.length;
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = (2*nums[i-1]%1000000007-nums[p[i-1]]+2)%1000000007;
        }
        return nums[n];
    }
}
