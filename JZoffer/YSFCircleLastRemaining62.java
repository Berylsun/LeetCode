class Solution {
    /**
     * 约瑟夫环
     * @param n
     * @param m
     * @return
     */

    /**
     * O(n^2)
     * O(n)
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (list.size() > 1) {
            int len = list.size();
            idx = (idx + m - 1) % len;
            list.remove(idx);
        }
        return list.get(0);
    }

    /**
     * O(n)
     * O(1)
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining2(int n, int m) {
        int ans = 0;
        for (int i = 1 ;i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }
}