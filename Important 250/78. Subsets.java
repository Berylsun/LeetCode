//2^n, n
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        int size = (int)Math.pow(2, nums.length);
        for (int i = 0; i < size; i++) {
            res.add(new ArrayList<>());
        }
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < size; j++) {
                if ((j >> i & 1) == 1) {
                    res.get(j).add(nums[i]);
                }
            }
        }
        
        return res;
    }
}

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), nums, 0);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int start) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            helper(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
