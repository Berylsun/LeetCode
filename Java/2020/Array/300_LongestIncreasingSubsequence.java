/**
 * O(nlogn)
 * O(n)
 * insertSort
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tail = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int l = 0;
            int r = res;
            while (l < r) {
                int mid = (r - l) / 2 + l;
                if (tail[mid] < num) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            tail[l] = num;
            if (l == res) {
                res++;
            }
        }
        return res;
    }
}