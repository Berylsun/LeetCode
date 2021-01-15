/**
 * O(logn)
 * O(1)
 */
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 1;
        int r = n;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == -1) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}