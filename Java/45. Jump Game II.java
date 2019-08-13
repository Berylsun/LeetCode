//n, 1
class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int res = 0;
        int cur = 0;
        int maxnext = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxnext = Math.max(maxnext, nums[i] + i);
            if (i == cur) {
                res++;
                cur = maxnext;
            }
        }
        return res;
    }
}


//bfs
class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int res = 0;
        int cur = 0;
        int maxnext = 0;
        int i = 0;
        while (cur - i + 1 > 0) {
            res++;
            for (; i <= cur; i++) {
                maxnext = Math.max(maxnext, nums[i] + i);
                if (maxnext >= nums.length - 1) {
                    return res;
                }
            }
            cur = maxnext;
        }
        return 0;
    }
}
