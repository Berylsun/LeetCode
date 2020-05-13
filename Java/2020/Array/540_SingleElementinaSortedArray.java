class Solution {
    /**
     * O(logn)
     * O(1)
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = (j - i) / 2 + i;
            if (mid % 2 == 1) {
                if (nums[mid] == nums[mid - 1]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            } else {
                if (mid < nums.length - 1 && nums[mid] == nums[mid + 1]) {
                    i = mid + 1;
                } else if (mid > 0 && nums[mid] == nums[mid - 1]) {
                    j = mid - 1;
                } else {
                    return nums[mid];
                }
            }
        }
        return nums[i];
    }

    public int singleNonDuplicate2(int[] nums) {
        int start = 0;
        int end = nums.length / 2;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[2 * mid] != nums[2 * mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return nums[2 * start];
    }
}