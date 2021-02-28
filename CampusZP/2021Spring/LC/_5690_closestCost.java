class Solution {
    int res;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        res = baseCosts[0];
        int n = baseCosts.length;
        int m = toppingCosts.length;
        for (int base : baseCosts) {
            helper(base, toppingCosts, target, 0, 0);
        }
        return res;
    }
    public void helper(int base, int[] nums, int target, int sum, int i) {
        int t = target - base;
        if (Math.abs(t - sum) < Math.abs(target - res)) {
            res = sum + base;
        } else if (Math.abs(t - sum) == Math.abs(target - res)) {
            res = Math.min(res, sum + base);
        }
        if (i >= nums.length) return;
        helper(base, nums, target, sum, i + 1);
        helper(base, nums, target, sum + nums[i], i + 1);
        helper(base, nums, target, sum + nums[i] * 2, i + 1);
    }

}