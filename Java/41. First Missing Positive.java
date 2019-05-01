class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        if (nums.length == 1) {
            if(nums[0] != 1) return 1;
            return 2;
        }
        int[] helper = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0 && nums[i] <= nums.length) {
                helper[nums[i] - 1]++;
            }
            
        }
        for(int i = 0; i < helper.length; i++) {
            if (helper[i] == 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
