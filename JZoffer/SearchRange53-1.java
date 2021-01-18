class Solution {
    /**
     * O(logn)
     * O(1)
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int low = findFirst(nums, target);
        int high = findLast(nums, target);
        return low == -1 ? 0 : high - low + 1;
    }

    public int findFirst(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid;
            }
        }
        if (nums[l] != target && nums[r] != target) {
            return -1;
        }
        return nums[l] == target ? l : r;
    }

    public int findLast(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return nums[r] == target ? r : l;
    }
}