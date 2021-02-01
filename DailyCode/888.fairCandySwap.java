class Solution {
    /**
     * O(mn)
     * O(1)
     * @param A
     * @param B
     * @return
     */
    public int[] fairCandySwap(int[] A, int[] B) {
        int minus = 0;
        int idx = 0;
        while (idx < A.length || idx < B.length) {
            if (idx < A.length) {
                minus += A[idx];
            }
            if (idx < B.length) {
                minus -= B[idx];
            }
            idx++;
        }

        minus /= 2;
        int[] res = new int[2];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] - B[j] == minus) {
                    res[0] = A[i];
                    res[1] = B[j];
                    break;
                }
            }
        }
        return res;

    }


    /**
     * O(n + m)
     * O(n)
     * @param A
     * @param B
     * @return
     */
    public int[] fairCandySwap2(int[] A, int[] B) {
        int minus = 0;
        int idx = 0;
        while (idx < A.length || idx < B.length) {
            if (idx < A.length) {
                minus += A[idx];
            }
            if (idx < B.length) {
                minus -= B[idx];
            }
            idx++;
        }

        minus /= 2;
        int[] res = new int[2];
        HashSet<Integer> set = new HashSet<>();
        for(int a : A) {
            set.add(a);
        }

        for (int b : B) {
            int y = b + minus;
            if(set.contains(y)) {
                res[0] = y;
                res[1] = b;
                break;
            }
        }
        return res;

    }
}