/**
 * O(n)
 * O(n)
 */

class Solution {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int res = 0;
        nums[0] = nums[0] == 0 ? -1 : 1;
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
            nums[i] = nums[i - 1] + nums[i];
            if (map.containsKey(nums[i])) {
                res = Math.max(res, i - map.get(nums[i]));
            } else {
                map.put(nums[i], i);
            }
        }
        return res;

    }
}


class Solution {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                res = Math.max(res, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return res;
    }
}