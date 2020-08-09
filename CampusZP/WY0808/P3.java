package WY;
// 价值平分
import java.util.Arrays;
import java.util.Scanner;

public class P3 {
    public static int minn = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int n = in.nextInt();
            int[] nums = new int[n];
            int sum = 0;
            for (int j = 0; j < n; j++) {
                nums[j] = in.nextInt();
                sum += nums[j];
            }
            Arrays.sort(nums);
            dfs(0, 0, nums, sum, 0);
            System.out.println(minn);
        }
    }

    public static void dfs(int x, int y, int[] nums, int sum, int idx) {
        if(x == y) {
            minn = Math.min(minn,sum);
        }
        if(sum == 0) return ;
        if(idx == nums.length) return ;
        dfs(x + nums[idx],y,nums, sum - nums[idx],idx + 1);
        dfs(x,y + nums[idx],nums, sum - nums[idx],idx + 1);
        dfs(x,y,nums, sum, idx + 1);
    }
}
