package KDXF0731;

import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int[] nums = new int[5];
        for (int i = 0; i < 5; i++) {
            nums[i] = in.nextInt();
        }
        int k = in.nextInt();
        int res = helper(nums, k);
        System.out.println(res);
    }

    public static int helper(int[] nums, int k) {
        int res = 0;
        while (k > 0) {
            if (k >= 100 && nums[4] > 0) {
                nums[4]--;
                res++;
                k = k - 100;
            } else if (k >= 50 && nums[3] > 0) {
                nums[3]--;
                res++;
                k = k - 50;
            } else if (k >= 10 && nums[2] > 0) {
                nums[2]--;
                res++;
                k = k - 10;
            } else if (k >= 5 && nums[1] > 0) {
                nums[1]--;
                res++;
                k = k - 5;
            } else {
                while (k > 0) {
                    if (nums[0] <= 0) {
                        return -1;
                    }
                    nums[0]--;
                    res++;
                    k--;
                }
            }
        }
        return res == 0 ? -1 : res;
    }
}
