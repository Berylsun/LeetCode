//n, 1
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int count = 1; // count can also be index of new nums
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {  //reverse thinking
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}
