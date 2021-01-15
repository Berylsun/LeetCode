/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int x, int y) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    /**
     * O(mlogn)
     * O(1)
     * @param binaryMatrix
     * @return
     */
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> inf = binaryMatrix.dimensions();
        int m = inf.get(0);
        int n = inf.get(1);
        int res = n;
        for (int i = 0; i < m; i++) {
            int l = 0;
            int r = n - 1;
            while (l + 1 < r) {
                int mid = (r - l) / 2 + l;
                if (binaryMatrix.get(i, mid) == 1) {
                    r = mid;
                } else {
                    l = mid;
                }
            }
            if(binaryMatrix.get(i, l) == 1) res = Math.min(res, l);
            if(binaryMatrix.get(i, r) == 1) res = Math.min(res, r);
        }
        return res == n ? -1 : res;
    }
}