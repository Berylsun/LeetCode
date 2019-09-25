class Solution {
    //Binarysearch
    public int shipWithinDays(int[] weights, int D) {
        if (weights == null || weights.length == 0) return 0;
        
        int left = 0, right = 0;
        for (int w: weights) {
            left = Math.max(left, w);
            right += w;
        }
        
        while (left < right) {
            int mid = (right - left) / 2 + left;
            int sum = 0;
            int index = 0;
            int days = 0;
            while (index < weights.length) {
                days++;
                while (index < weights.length && sum + weights[index] <= mid) {
                    sum += weights[index];
                    index++;
                }
                sum = 0;
            }
            
            if (days > D) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        
        return left;
    }
}
