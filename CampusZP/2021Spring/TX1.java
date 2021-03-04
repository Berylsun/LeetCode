public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] nums = new int[]{1, 3, 3, 4, 3};
        int target = 7;
        int[] ans = helper(nums, target);
        for (int n : ans) {
            System.out.println(n);
        }
    }

    /**
     * 最短子数组
     * @param nums
     * @param target
     * @return
     */
    public static int[] helper(int[] nums, int target) {
        int sum = 0;
        int start = 0;
        int end = -1;
        int rs = 0;
        int re = -1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == target) {
                end = i;
                if (re == -1 || re - rs > end - start) {
                    re = end;
                    rs = start;
                }
            } else if (sum > target) {
                while (sum > target && start < nums.length) {
                    sum -= nums[start++];
                }
                if (sum == target) {
                    end = i;
                    if (re == -1 || re - rs > end - start) {
                        re = end;
                        rs = start;
                    }
                }
            }
        }
        int[] res = new int[re - rs + 1];
        int idx = 0;
        for (int i = rs; i <= re; i++) {
            res[idx++] = nums[i];
        }
        return res;
    }
}
