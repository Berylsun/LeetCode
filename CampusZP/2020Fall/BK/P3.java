package BK;
// 或 子序列
import java.util.Scanner;

public class P3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextLong();
        }

        int inter = helper(nums);
        System.out.println(inter);
    }

    public static int helper(long[] nums) {
        long num = nums[0];
        int inter = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            num |= nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            long sum = nums[i];
            for (int j = i; j < nums.length; j++) {
                sum |= nums[j];
                if (sum == num) {
                    inter = Math.min(inter, j - i + 1);
                }
            }
        }
        return inter;
    }
}
