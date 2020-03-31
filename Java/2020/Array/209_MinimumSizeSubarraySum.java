/**
 * O(n)
 * O(1)
 */
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0;
        int left = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s && left <= i) {
                res = Math.min(res, i - left + 1);
                sum -=nums[left++];
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}