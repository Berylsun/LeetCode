//2^n, n
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        helper(res, candidates, target, new ArrayList<>(), 0);
        return res;
    }
    
    public void helper(List<List<Integer>> res, int[] candidates, int target, List<Integer> list, int start) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (i != start && candidates[i] == candidates[i - 1]) continue;
            list.add(candidates[i]);
            helper(res, candidates, target - candidates[i], list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
