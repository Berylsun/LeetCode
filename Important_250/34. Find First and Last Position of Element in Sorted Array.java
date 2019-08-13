//logn, 1
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) return res;
        res[0] = findStart(nums, target);
        res[1] = findEnd(nums, target);
        return res;
    }
    
    public int findStart(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i + 1 < j) {
            int mid = (j - i) / 2 + i;
            if (target <= nums[mid]) {
                j = mid;
            }else {
                i = mid;
            }
        }
        if (nums[i] == target) return i;
        if (nums[j] == target) return j;
        return -1;
    }
    
    public int findEnd(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i + 1 < j) {
            int mid = (j - i) / 2 + i;
            if (target >= nums[mid]) {
                i = mid;
            }else {
                j = mid;
            }
        }
        if (nums[j] == target) return j;
        if (nums[i] == target) return i;        
        return -1;
    }
}
