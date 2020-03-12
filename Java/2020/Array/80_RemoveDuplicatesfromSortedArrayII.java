//O(n), O(1)
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) return nums.length;
        int res = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[res - 2] != nums[i]) {  // figure out compare elements !!!
                nums[res++] = nums[i];
            }
        }
        return res;
    }
}