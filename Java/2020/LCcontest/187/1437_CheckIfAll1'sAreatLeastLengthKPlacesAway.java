class Solution {
    /**
     * O(n)
     * O(1)
     * @param nums
     * @param k
     * @return
     */
    public boolean kLengthApart(int[] nums, int k) {
        int idx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (idx == -1 && nums[i] == 1) {
                idx = i;
            } else if (nums[i] == 1) {
                if (i - idx - 1 < k) {
                    return false;
                }
                idx = i;
            }
        }
        return true;
    }
}