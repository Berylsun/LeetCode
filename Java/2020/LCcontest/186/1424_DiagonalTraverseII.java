class Solution {
    /**
     * O(m * n)
     * O(m * n)
     * @param nums
     * @return
     */
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int n = 0, i = 0;
        int rows = nums.size(), cols = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int r = rows - 1; r >= 0; r--) { // The values from the bottom rows are the starting values of the diagonals.
            for (int c = 0; c < nums.get(r).size(); c++) {
                map.putIfAbsent(r + c, new ArrayList<>());
                map.get(r + c).add(nums.get(r).get(c));
                n++;
            }
            cols = Math.max(cols, nums.get(r).size());
        }
        int[] ans = new int[n];
        for (int key = 0; key <= rows + cols; key++) {
            List<Integer> value = map.get(key);
            if (value == null) continue;
            for (int v : value) ans[i++] = v;
        }
        return ans;
    }
}