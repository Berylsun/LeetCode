class Solution {
    public int maxRotateFunction(int[] A) {
        int sum = 0;
        int res = 0;
        int candidate = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            candidate += i * A[i];
        }
        res = candidate;
        //F(k) - F(k - 1) = sum - nBk[0];
        for (int i = 1; i < A.length; i++) {
            candidate = candidate + sum - A.length * A[A.length - i];
            res = Math.max(candidate, res);
        }
        return res;
    }
}

//暴力解……
class Solution {
    public static int maxRotateFunction(int[] A) {
            if (A == null || A.length == 0) return 0;
            int res = Integer.MIN_VALUE;
            for (int i = 0; i < A.length; i++) {
                res = Math.max(res, rotate(A, i == 0 ? 0 : 1));
            }
            return res;
        }

        public static int rotate(int[]A, int k) {
            int res = 0;
            if (k > 0) {
                reverse(A, 0, A.length - 1);
                reverse(A, 0, k - 1);
                reverse(A, k, A.length - 1);
            }

            for (int i = 0; i < A.length; i++) {
                res += i * A[i];
            }
            return res;
        }

        public static void reverse(int[]A, int start, int end) {
            int temp = 0;
            while (start < end) {
                temp = A[start];
                A[start] = A[end];
                A[end] = temp;
                start++;
                end--;
            }
        }
}
