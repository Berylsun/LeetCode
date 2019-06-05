/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        int mid = 0;
        while (start <= end) {
            mid = (end - start) / 2 + start;
            if (guess(mid) == 0) {
                return mid;
            }else if (guess(mid) == 1) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return start;
    }
}