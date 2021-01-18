class Solution {
    /**
     * O(n)
     * O(1)
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * O(logn)
     * O(1)
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == mid) {
                l = mid;
            } else {
                r = mid;
            }
        }
        if (nums[l] != l) return l;
        if (nums[r] != r) return r;
        return r + 1;
    }
}