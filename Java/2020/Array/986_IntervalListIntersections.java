class Solution {
    /**
     * O(m + n)
     * @param A
     * @param B
     * @return
     */
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> res = new ArrayList<>();
        if (A == null || B == null || A.length == 0 || B.length == 0) return new int[][]{};
        int a = 0;
        int b = 0;
        while (a < A.length && b < B.length) {
            if (A[a][1] < B[b][0] || B[b][1] < A[a][0]) {
                if (A[a][1] < B[b][0]) {
                    a++;
                } else {
                    b++;
                }
            } else {
                int[] temp = new int[2];
                temp[0] = Math.max(A[a][0], B[b][0]);
                if (A[a][1] < B[b][1]) {
                    temp[1] = A[a][1];
                    a++;
                } else {
                    temp[1] = B[b][1];
                    b++;
                }
                res.add(temp);
            }
        }
        return res.toArray(new int[][]{});
    }
}