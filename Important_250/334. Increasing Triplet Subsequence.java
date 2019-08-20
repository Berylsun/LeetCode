//n, 1
class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        
        int min = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        int max = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }else if (nums[i] < mid && nums[i] > min) {
                mid = nums[i];
            }else if (nums[i] > mid){
                return true;
            }
        }
        
        return false;
    }
}
