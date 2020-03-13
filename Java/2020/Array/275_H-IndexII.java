//O(logn), O(1) binary search
class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        int len = citations.length;
        int i = 0;
        int j = len - 1;
        while (i <= j) {
            int mid = (j - i) / 2 + i;
            if (citations[mid] == len - mid) {
                return len - mid;
            }
            if (citations[mid] > len - mid) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return len - i;
    }
}