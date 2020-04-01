/**
 * O(logn)
 * O(1)
 */
class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int res = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (nums[l] <= nums[mid]) {
                res = Math.min(res, nums[l]);
                l = mid + 1;
            }
            if (nums[mid] <= nums[r]) {
                res = Math.min(nums[mid], res);
                r = mid - 1;
            }
        }

        return res;
    }

    public int findMin2(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        if (nums[start] < nums[end]) return nums[start];
        else return nums[end];
    }
}