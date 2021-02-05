class Solution {
    /**
     * timeout
     */
    List<String> res;
    public String getPermutation(int n, int k) {
        boolean[] used = new boolean[n + 1];
        res = new ArrayList<>();
        helper(n, "", used);
        return res.get(k - 1);
    }

    public void helper(int n, String s, boolean[] used) {
        if (s.length() == n) {
            res.add(s);
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (used[i]) continue;
            used[i] = true;
            helper(n, s + i, used);
            used[i] = false;
        }
    }

    /**
     * O(n^2)
     * O(n)
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0;i < n; i++) {
            res.add(i + 1);
        }
        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = i * fact[i - 1];
        }
        StringBuilder sb = new StringBuilder();
        k--;
        for (int i = n - 1; i >= 0; i--) {
            int idx = k / fact[i];
            k %= fact[i];
            sb.append(res.get(idx));
            res.remove(idx);
        }
        return sb.toString();
    }
}