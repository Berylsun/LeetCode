public class SubarrayProductLessThanK_713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        int num = 1;
        int i = 0;
        if (k <= 1) return res;
        for (int j = 0; j < nums.length; j++) {
            num *= nums[j];
            while (num >= k) {
                num /= nums[i++];
            }
            res += j - i + 1;
        }
        return res;
    }
}
