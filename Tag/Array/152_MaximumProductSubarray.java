/**
 * O(n)
 * O(1)
 */
class Solution {
    public int maxProduct(int[] nums) {
        int small = nums[0];
        int large = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = small;
            small = Math.min(nums[i], Math.min(nums[i] * small, nums[i] * large));
            large = Math.max(nums[i], Math.max(nums[i] * large, nums[i] * temp));
            res = Math.max(res, large);
        }

        return res;
    }
}