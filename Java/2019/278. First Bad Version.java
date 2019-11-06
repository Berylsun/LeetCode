/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int mid = 0;
        int start = 1;
        int end = n;
        while (start < end) {
            mid = (end - start) / 2 + start;
            if (isBadVersion(mid)) {
                end = mid;
            }else {
                start = mid + 1;
            }
        }
        return start;
    }
}
