//n, 1
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(robber(0, nums.length - 2, nums), robber(1, nums.length - 1, nums));
    }
    
    public int robber(int start, int end, int[] nums) {
        int yes = 0;
        int no = 0;
        for (int i = start; i <= end; i++) {
            int temp = no;
            no = Math.max(yes, no);
            yes = temp + nums[i];
        }
        
        return Math.max(no, yes);
    }
}
