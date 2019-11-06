// n, 1
class Solution {
    public int minPatches(int[] nums, int n) {
        int res = 0;
        long miss = 1; //表示[0,n]之间最小的不能表示的值
        int i = 0;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            }else {
                miss += miss;
                res++;
            }
        }
        return res;
    }
}
