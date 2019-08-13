//n, 1
class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int temp = min;
            min = Math.min(Math.min(nums[i], nums[i] * min), nums[i] * max);
            max = Math.max(Math.max(nums[i], nums[i] * temp), nums[i] * max);
            res = Math.max(res, max);
        }
        
        return res;
    }
}
