package ST;

import java.util.Scanner;

public class P2 {
    public static int res = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                helper(nums, i, j, 1, Integer.MIN_VALUE);
            }
        }
        System.out.println(res);
    }

    private static void helper(int[][] nums, int i, int j, int sum, int pre) {
        if (i < 0 || i >= nums.length || j < 0 || j >= nums[0].length) return;
        if (pre != Integer.MIN_VALUE && nums[i][j] <= pre) return;
        res = Math.max(res, sum);
        pre = nums[i][j];
        helper(nums, i + 1, j, sum + 1, pre);
        helper(nums, i - 1, j, sum + 1, pre);
        helper(nums, i, j + 1, sum + 1, pre);
        helper(nums, i , j - 1, sum + 1, pre);
    }
}
