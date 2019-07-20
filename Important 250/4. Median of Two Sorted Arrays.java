//log(min(m, n)), 1  **Binary Search**

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
             return findMedianSortedArrays(nums2, nums1);
        }
        
        int cut1 = 0; // the number of elements int cut1
        int cut2 = 0; // the number of elements int cut2
        int cutL = 0;
        int cutR = nums1.length;
        int len = nums1.length + nums2.length;
        /**
         find median
        */
        while (cut1 <= nums1.length) {
            cut1 = (cutR - cutL) / 2 + cutL;
            cut2 = len / 2 - cut1;
            double L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            double R1 = (cut1 == nums1.length) ? Integer.MAX_VALUE : nums1[cut1];
            double L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            double R2 = (cut2 == nums2.length) ? Integer.MAX_VALUE : nums2[cut2];
            if (L1 > R2) {
                cutR = cut1 - 1;
            }else if (R1 < L2) {
                cutL = cut1 + 1;
            }else {  // must satisfy L1 <= R2 && R1 <= L2
                if (len % 2 == 0) {
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
                }else {
                    return R1 < R2 ? R1 : R2;
                }
            }            
        }
        return -1;
    }
}
