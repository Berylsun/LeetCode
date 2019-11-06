class Solution {
    public int hIndex(int[] citations) {
        int start = 0;
        int end = citations.length - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (citations[mid] == citations.length - mid) {
                return citations.length - mid;
            }
            if (citations[mid] > citations.length - mid) {
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return citations.length - start;
    }
}
