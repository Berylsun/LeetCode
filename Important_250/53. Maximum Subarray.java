//n, 1  
DP
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int cur = 0;
        int pre = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = pre < 0 ? nums[i] : pre + nums[i];
            res = Math.max(res, cur);
            pre = cur;
        }
        return res;
    }
}
