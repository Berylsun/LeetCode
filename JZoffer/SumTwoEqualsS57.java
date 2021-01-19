class Solution {
    /**
     * O(n)
     * O(1)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int[] res = new int[2];
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == target) {
                res[0] = nums[l];
                res[1] = nums[r];
                break;
            }
            if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}