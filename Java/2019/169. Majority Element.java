class Solution {
    public int majorityElement(int[] nums) {
        //moore vote
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == res) {
                count++;
            }else if (count == 0) {
                res = nums[i];
                count++;
            }else {
                count--;
            }
        }
        return res;
    }
}
