class Solution {
    /**
     * O((nlogn)^2) -> O(n^2 logn)
     * O(n^2)
     */
    int count = 0;
    public int regionsBySlashes(String[] grid) {
        if (grid == null || grid.length == 0) return 0;
        int len = grid.length;
        int[] uf = new int[4 * len * len];
        count = uf.length;
        for (int i = 0; i < uf.length; i++) {
            uf[i] = i;
        }

        for (int i = 0; i < len; i++) {
            String str = grid[i];
            for (int j = 0; j < len; j++) {
                int idx = i * len + j;
                char c = str.charAt(j);
                if (c == ' ') {
                    merge(uf, idx * 4, idx * 4 + 1);
                    merge(uf, idx * 4 + 1, idx * 4 + 2);
                    merge(uf, idx * 4 + 2, idx * 4 + 3);
                } else if (c == '/') {
                    merge(uf, idx * 4, idx * 4 + 3);
                    merge(uf, idx * 4 + 1, idx * 4 + 2);
                } else {
                    merge(uf, idx * 4, idx * 4 + 1);
                    merge(uf, idx * 4 + 2, idx * 4 + 3);
                }

                if (j < len - 1) {
                    merge(uf, idx * 4 + 1, (idx + 1) * 4 + 3);
                }
                if (i < len - 1) {
                    int bottom = (i + 1) * len + j;
                    merge(uf, idx * 4 + 2, bottom * 4);
                }
            }
        }

        // Set<Integer> set = new HashSet<>();
        // for (int i = 0; i < uf.length; i++) {
        //     set.add(find(uf, i));
        // }
        return count;
    }

    public int find(int[]uf, int i) {
        if (uf[i] != i) {
            uf[i] = find(uf, uf[i]);
        }
        return uf[i];
    }

    public void merge(int[] uf, int x, int y) {
        int fx = find(uf, x);
        int fy = find(uf, y);
        if (fx != fy) {
            count--;
        }
        uf[fx] = fy;
    }
}