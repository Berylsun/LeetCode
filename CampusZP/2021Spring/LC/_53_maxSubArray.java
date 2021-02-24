class Solution {
    /**
     * O(n)
     * O(1)
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = nums[0];
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            num = Math.max(num + n, n);
            res = Math.max(res, num);
        }
        return res;
    }
}