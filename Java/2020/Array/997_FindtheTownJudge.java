class Solution {
    /**
     * O(n + N)
     * O(N)
     * @param N
     * @param trust
     * @return
     */
    public int findJudge(int N, int[][] trust) {
        int[] count = new int[N + 1];
        for (int[] num : trust) {
            count[num[0]]--;
            count[num[1]]++;
        }
        for (int i = 1; i < N + 1; i++) {
            if (count[i] == N - 1) return i;
        }
        return -1;
    }
}