//BinarySearch

class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int left = 0;
        int right = A.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            //找不满足的条件！！！
            if (A[mid - 1] > A[mid]) {
                right = mid - 1;
            }else if (A[mid] < A[mid + 1]) {
                left = mid + 1;
            }else {
                return mid;
            }
        }
        
        return left;
    }
}
