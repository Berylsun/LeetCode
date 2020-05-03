class Solution {
    /**
     * O(m * n)
     * O(m * n)
     * @param mat
     * @param k
     * @return
     */
    public int kthSmallest(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        List<Integer> last = new ArrayList<>();
        last.add(0);
        for (int i = 0; i < n; i++) {
            List<Integer> next = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                for (int z : last) {
                    next.add(mat[i][j] + z);
                }
            }
            Collections.sort(next);
            last = new ArrayList<>();
            for (int j = 0; j < k && j < next.size(); j++) {
                last.add(next.get(j));
            }
        }
        return last.get(k - 1);
    }
}