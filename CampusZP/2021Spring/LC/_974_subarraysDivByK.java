class Solution {
    /**
     * O(n)
     * O(n)
     * @param A
     * @param K
     * @return
     */
    public int subarraysDivByK(int[] A, int K) {
        int res = 0;
        if (A == null || A.length == 0) return 0;
        // 同余定理: (P[j]−P[i−1])modK==0 <==> P[j]modK==P[i−1]modK
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int a : A) {
            sum += a;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int mod = (sum % K + K) % K;
            int same = map.getOrDefault(mod, 0);
            res += same;
            map.put(mod, same + 1);
        }
        return res;
    }
}