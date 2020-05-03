class Solution {
    /**
     * O(n)
     * O(n)
     * @param nums
     * @param limit
     * @return
     */
    public int longestSubarray(int[] nums, int limit) {
        int res = 1;
        int j = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (!check(map, limit)) {
                int value = nums[j];
                map.put(value, map.get(value) - 1);
                if (map.get(value) == 0) {
                    map.remove(value);
                }
                j++;
            }
            res = Math.max(i - j + 1, res); //!!!
        }
        return res;
    }

    public boolean check(TreeMap<Integer, Integer> map, int limit) {
        if (map.lastKey() - map.firstKey() > limit) {
            return false;
        }
        return true;
    }
}