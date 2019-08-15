//logn, 1
class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        
        int l = 0;
        int r = citations.length - 1;
        
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (citations[mid] == citations.length - mid) {
                return citations[mid];
            }
            if (citations[mid] < citations.length - mid) {
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        
        return citations.length - l;
    }
}
