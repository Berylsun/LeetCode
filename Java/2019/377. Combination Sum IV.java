//2^n, n
class Solution {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        return helper(nums, target, map);
    }
    
    public int helper(int[] nums, int target, HashMap<Integer, Integer> map) {
        if (target < 0) return 0;
        if (target == 0) return 1;
        if (map.containsKey(target)) {
            return map.get(target);
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += helper(nums, target - nums[i], map);
        }
        map.put(target, res);
        return res;
    }
}

//n * k, k
class Solution {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int[] res = new int[target + 1];
        res[0] = 1;
        for (int i = 0; i < target + 1; i++) {
            for (int num : nums) {
                if (i - num >= 0) {
                    res[i] += res[i - num];
                }                
            }
        }
        return res[target];
    }
}
