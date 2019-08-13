//n, 1
class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        k %= nums.length;
        reverse(0, nums.length - 1, nums);
        reverse(0, k - 1, nums);
        reverse(k, nums.length - 1, nums);
    }
    
    public void reverse(int i, int j, int[] nums) {
        while (i < j) {
            int temp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = temp;
        }
    }
}
