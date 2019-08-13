//m+n, 1
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) return;
        int id1 = m - 1;
        int id2 = n - 1;
        int k = m + n - 1;
        while (id1 >= 0 && id2 >= 0) {
            nums1[k--] = nums1[id1] >= nums2[id2] ? nums1[id1--] : nums2[id2--];
        }
        
        while (id2 >= 0) {
            nums1[k--] = nums2[id2--];
        }
    }
}
