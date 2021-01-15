/**
 * O(n)
 * O(1)
 */
class Solution {
    public int jump(int[] nums) {
        int res = 0;
        int max = 0;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i] + i);
            //make sure that when jump to the end don't add one more
            if (i == cur && i != nums.length - 1) {
                res++;
                cur = max;
            }
        }
        return res;
    }
}