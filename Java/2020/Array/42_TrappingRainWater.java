/**
 * O(n)
 * O(1)
 */
class Solution {
    public int trap(int[] height) {
        int res = 0;
        if (height == null || height.length == 0) return res;
        int l = 0;
        int r = height.length - 1;
        int maxl = 0;
        int maxr = 0;
        while (l < r) {
            if (height[l] <= height[r]) {
                maxl = Math.max(maxl, height[l]);
                res += maxl - height[l];
                l++;
            } else {
                maxr = Math.max(maxr, height[r]);
                res += maxr - height[r];
                r--;
            }
        }
        return res;
    }
}