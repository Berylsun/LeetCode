//n, n
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        List<HashSet<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<>());
        }
        
        for (int[] temp : edges) {
            adj.get(temp[0]).add(temp[1]);
            adj.get(temp[1]).add(temp[0]);
        }
        
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1) {
                res.add(i);
            }
        }
        
        while (n > 2) {
            n -= res.size();
            List<Integer> leaves = new ArrayList<>();
            for (int i : res) {
                for (int k : adj.get(i)) {
                    adj.get(k).remove(i);
                    if (adj.get(k).size() == 1) {
                        leaves.add(k);
                    }
                }
            }
            res = leaves;
        }
        return res;
    }
}
