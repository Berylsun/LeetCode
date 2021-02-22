class Solution {
    /**
     * O(n)
     * O(n)
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 2; i >= 0; i--) {
            res[i] *= right * nums[i + 1];
            right *= nums[i + 1];
        }
        return res;
    }
}