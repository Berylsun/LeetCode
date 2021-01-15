class Solution {
    /**
     * O(n * k)
     * O(n)
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        int[] res = new int[target + 1];
        res[0] = 1;
        for (int i = 0; i < res.length; i++) {
            for (int num : nums) {
                if (i >= num) {
                    res[i] += res[i - num];
                }
            }
        }
        return res[target];
    }

    /**
     * O(n^2)
     * O(n)
     * @param nums
     * @param target
     * @return
     */

    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int[] res = new int[target + 1];
        Arrays.fill(res, -1);
        // res[0] = 1;
        helper(res, target, nums);
        return res[target];
    }

    public int helper(int[]res, int target, int[] nums) {
        if (target < 0) return 0;
        if (target == 0) return 1;
        if (res[target] != -1) {
            return res[target];
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                count += helper(res, target - nums[i], nums);
            }
        }
        res[target] = count;
        return count;
    }
}