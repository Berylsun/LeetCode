class Solution {
    /**
     * O(n)
     * O(1)
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int l = 0;
        int r = height.length - 1;
        int maxl = height[l];
        int maxr = height[r];
        int res = 0;
        while (l < r) {
            if (height[l] < height[r]) {
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