//O(n), O(n)
class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int len = nums.length;
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        int gap = (int)Math.ceil((double)(max - min) / (len - 1));
        int[] bucketmin = new int[len - 1];
        int[] bucketmax = new int[len - 1];
        Arrays.fill(bucketmin, Integer.MAX_VALUE);
        Arrays.fill(bucketmax, Integer.MIN_VALUE);        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == min || nums[i] == max) continue;
            int bucket = (nums[i] - min) / gap;
            bucketmin[bucket] = Math.min(bucketmin[bucket], nums[i]);
            bucketmax[bucket] = Math.max(bucketmax[bucket], nums[i]);
        }
        int pre = min;
        int res = 0;
        for (int i = 0; i < len - 1; i++) {
            if (bucketmin[i] == Integer.MAX_VALUE) continue;
            res = Math.max(res, bucketmin[i] - pre);
            pre = bucketmax[i];
        }
        res = Math.max(res, max - pre);
        return res;
    }
}
