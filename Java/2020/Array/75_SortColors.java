/**
 * O(n)
 * O(1)
 */
class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int l = 0;
        int r = nums.length - 1;
        int idx = 0;
        while (idx <= r) {
            if (nums[idx] == 0) {
                swap(nums, idx++, l++);
            } else if (nums[idx] == 1) {
                idx++;
            } else {
                swap(nums, idx, r--);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}