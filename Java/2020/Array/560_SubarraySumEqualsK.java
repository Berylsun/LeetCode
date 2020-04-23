class Solution {
    /**
     * O(n)
     * O(n)
     * Integer may be negetive!!!
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int res = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            // sum instead of nums[i] += nums[i - 1];
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}