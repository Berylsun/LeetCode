class Solution {
    /**
     * O(NKlogN)
     * O(NK)
     * @param K
     * @param N
     * @return
     */
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(dp[i], i);
        }


        for (int i = 0; i < N + 1; i++) {
            dp[i][0] = 0;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                int l = 1;
                int r = i;
                while (l + 1 < r) {
                    int mid = l + (r - l) / 2;
                    int b = dp[mid - 1][j - 1];
                    int nb = dp[i - mid][j];
                    if (b > nb) {
                        r = mid;
                    } else {
                        l = mid;
                    }
                }
                dp[i][j] = 1 + Math.min(Math.max(dp[l - 1][j - 1], dp[i - l][j]),Math.max(dp[r - 1][j - 1], dp[i - r][j]));
            }
        }

        return dp[N][K];
    }



    Map<Integer, Integer> memo = new HashMap();
    public int superEggDrop(int K, int N) {
        if (!memo.containsKey(N * 100 + K)) {
            int ans;
            if (N == 0) {
                ans = 0;
            } else if (K == 1) {
                ans = N;
            } else {
                int lo = 1, hi = N;
                while (lo + 1 < hi) {
                    int x = (lo + hi) / 2;
                    int t1 = superEggDrop(K-1, x-1);
                    int t2 = superEggDrop(K, N-x);

                    if (t1 < t2) {
                        lo = x;
                    } else if (t1 > t2) {
                        hi = x;
                    } else {
                        lo = hi = x;
                    }
                }

                ans = 1 + Math.min(Math.max(superEggDrop(K - 1, lo - 1), superEggDrop(K, N - lo)), Math.max(superEggDrop(K - 1, hi - 1), superEggDrop(K, N - hi)));
            }

            memo.put(N * 100 + K, ans);
        }

        return memo.get(N * 100 + K);
    }
}