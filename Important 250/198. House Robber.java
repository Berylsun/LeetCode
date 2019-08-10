//n, 1
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int yes = 0;
        int no = 0;
        for (int num : nums) {
            int temp = no;
            no = Math.max(yes, no);
            yes = temp + num;
        }
        
        return Math.max(yes, no);
    }
}
