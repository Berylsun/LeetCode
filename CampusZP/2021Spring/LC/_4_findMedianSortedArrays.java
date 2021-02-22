class Solution {
    /**
     * O(log(min(m, n))),
     * O(1)
     * Binary Search
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) return findMedianSortedArrays(nums2, nums1);
        int len = (m + n) / 2;
        int cut1 = 0;
        int cutl = 0;
        int cutr = m - 1;
        int cut2 = 0;
        while (cut1 <= m) {
            cut1 = (cutr - cutl) / 2 + cutl;
            cut2 = len - cut1;
            double L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            double R1 = (cut1 == m) ? Integer.MAX_VALUE : nums1[cut1];
            double L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            double R2 = (cut2 == n) ? Integer.MAX_VALUE : nums2[cut2];
            if (R1 < L2) {
                cutl = cut1 + 1;
            } else if (L1 > R2) {
                cutr = cut1 - 1;
            } else {
                if ((m + n) % 2 == 0) {
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
                } else {
                    return Math.min(R1, R2);
                }
            }
        }
        return -1;
    }
}