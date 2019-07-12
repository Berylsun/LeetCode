//n, 1
class Solution {
    public int rob(int[] nums) {
        int preNo = 0;
        int preYes = 0;
        for (int num : nums) {
            int temp = preNo;
            preNo = Math.max(preYes, preNo);
            preYes = temp + num;
        }
        return Math.max(preYes, preNo);
    }
}
