public class HWInter {
    public static void main(String[] args) {
        int[] nums = new int[]{-4, -3, -2, 1, 0, 3};
        int res = helper(nums);
        System.out.println(res);
    }

    public static int helper(int[] nums) {
        int res = nums[0];
        int curmin = nums[0];
        int curmax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tempmin = curmin;
            curmin = Math.min(nums[i], Math.min(curmax * nums[i], curmin * nums[i]));
            curmax = Math.max(nums[i], Math.max(tempmin * nums[i],curmax * nums[i]));
            res = Math.max(res, curmax);
        }
        return res;
    }
}
