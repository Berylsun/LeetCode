class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int start = 0;
        int res = nums.length + 1;
        int sum = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                res = Math.min(res, i - left + 1);
                sum -= nums[left++];
            }
        }
        return res == nums.length + 1 ? 0: res;
    }
}
