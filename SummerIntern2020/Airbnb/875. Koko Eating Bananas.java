class Solution {
    //Binary search !!!
    public int minEatingSpeed(int[] piles, int H) {
        if (piles == null || piles.length == 0) return 0;
        int left = 1;
        int right = 0;
        for (int num : piles) {
            right = Math.max(num, right);
        }
        
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int hour = 0;
            for (int num : piles) {
                hour += num % mid == 0 ? num / mid : num / mid + 1;
            }
            if (hour == H) {
                return mid;
            }
            if (hour > H) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        
        
        /*
         while (left < right) {
            int mid = (right - left) / 2 + left;
            int hour = 0;
            for (int num : piles) {
                hour += num % mid == 0 ? num / mid : num / mid + 1;
            }

            if (hour > H) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        */
        return left;
    }
    

}
