//2^n, n
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, k, n, new ArrayList<>(), 1);
        return res;
    }
    
    public void helper(List<List<Integer>> res, int k, int n, List<Integer> list, int start) {
        if (k < 0 || n < 0) return;
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = start; i <= 9; i++) {
            list.add(i);
            helper(res, k - 1, n - i, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
