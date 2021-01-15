class Solution {
    /**
     * O(n)
     * O(1)
     * @param A
     * @return
     */
    public int maxSubarraySumCircular(int[] A) {
        if (A == null || A.length == 0) return 0;
        int maxsum = A[0];
        int minsum = A[0];
        int max = 0;
        int min = 0; // can not be Integer.MAX_VALUE, because min + a (a<0) will overflow;
        int total = 0;
        for (int a : A) {
            max = Math.max(max + a, a);
            maxsum = Math.max(maxsum, max);
            min = Math.min(min + a, a);
            minsum = Math.min(min, minsum);
            total += a;
        }

        //Corner case
        //Just one to pay attention:
        //If all numbers are negative, maxSum = max(A) and minSum = sum(A).
        //In this case, max(maxSum, total - minSum) = 0, which means the sum of an empty subarray.
        //According to the deacription, We need to return the max(A), instead of sum of am empty subarray.
        //So we return the maxSum to handle this corner case.
        return maxsum > 0 ? Math.max(maxsum, total - minsum) : maxsum;
    }
}