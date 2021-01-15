/**
 * O(nlogn)
 * O(n)
 */
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) return 0;
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] tail = new int[envelopes.length];
        int res = 0;
        for (int[] envelop : envelopes) {
            int i = binarySearch(tail, 0, res, envelop[1]); //find the position
            tail[i] = envelop[1];
            if (i == res) {
                res++;
            }
        }
        return res;
    }

    public int binarySearch(int[] nums, int l, int res, int target) {
        int r = res - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}