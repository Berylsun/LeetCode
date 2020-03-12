//O(n), O(1)
class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        for (int i = 0; i < nums.length; i++) {
            // nums[i] <= nums.length "="
            // should omit && nums[i] != i + 1
            if (nums[i] <= nums.length && nums[i] > 0 && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[i];
                int j = nums[i] - 1;
                // if not j, nums[i] - 1 will change
                nums[i] = nums[j];
                nums[j] = temp;
                i--;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}