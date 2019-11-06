class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1,-1};
        int[] res = new int[2];
        res[0] = findStart(nums, target);
        res[1] = findEnd(nums, target);
        return res;
    }
    
    public int findStart(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        int idx = -1;
        while (s <= e) {
            int mid = (e - s) / 2 + s;
            if (nums[mid] >= target) {
                e = mid - 1;
            }else {
                s = mid + 1;
            }
            //if (nums[mid] == target) idx = mid;
        }
        return s < nums.length && nums[s] == target ? s : -1;
    }
    
    public int findEnd(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        int idx = -1;
        while (s <= e) {
            int mid = (e - s) / 2 + s;
            if (nums[mid] <= target) {
                s = mid + 1;
            }else {
                e = mid - 1;
            }
            //if (nums[mid] == target) idx = mid;
        }
        return e >= 0 && nums[e] == target ? e : -1;
    }
}
