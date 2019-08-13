//n, 1
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }
    
    public int helper(int[] nums, int lo, int hi) {
        int preNo = 0, preYes = 0;
        for (int i = lo; i <= hi; i++) {
            int temp = preNo;
            preNo = Math.max(preYes, preNo);
            preYes = nums[i] + temp;
        }
        return Math.max(preNo, preYes);
    }
}
