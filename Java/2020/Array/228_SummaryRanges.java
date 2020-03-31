/**
 * O(n)
 * O(n)
 */
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        for (int i = 0; i < nums.length; i++) {
            int start = i;
            while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            if (i == start) {
                res.add(Integer.toString(nums[start]));
            } else if (i == nums.length) {
                break;
            } else {
                res.add(nums[start] + "->" + nums[i]);
            }
        }
        return res;
    }
}