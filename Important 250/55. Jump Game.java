//n, 1
class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length < 2) return true;
        int curMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > curMax) return false;
            curMax = Math.max(curMax, i + nums[i]);
        }
        return true;
    }
}
