class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[end] > nums[mid]) {
                end = mid;
            }else if (nums[end] == nums[mid]) {
                end--;
            }else {
                start = mid + 1;
            }
        }
        return Math.min(nums[start], nums[end]);
    }
}
