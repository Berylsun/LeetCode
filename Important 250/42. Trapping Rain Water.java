//n, 1
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int l = 0;
        int r = height.length - 1;
        int lmax = height[l];
        int rmax = height[r];
        int res = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                lmax = Math.max(lmax, height[l]);
                res += lmax - height[l];
                l++;
            }else {
                rmax = Math.max(rmax, height[r]);
                res += rmax - height[r];
                r--;
            }
        }
        return res;
    }
}
