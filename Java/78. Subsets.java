//O(2^n), O(n) (回溯法！)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0 || nums == null) {
            return res;
        }
        helper(res, new ArrayList<>(), nums, 0);
        return res;
    }
    
    public void helper(List<List<Integer>> res, ArrayList<Integer> list, int nums[], int index) {
        res.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            helper(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
