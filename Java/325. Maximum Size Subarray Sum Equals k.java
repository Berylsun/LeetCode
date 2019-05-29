class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        HashMap<Integer> map = new HashMap<>();
        map.put(0, -1);//否则从头开始加的数字就没有比较了……比如第一个数字
        for (int i = 1 ; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i] - k)) {
                res = Math.max(res, i - map.get(nums[i] - k));
            }
            if (!map.containsKey(nums[i])) {
                put(nums[i], i);
            }
        }
        return res;
    }
}
