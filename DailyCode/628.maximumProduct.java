class Solution {
    /**
     * O(nlogn)
     * O(logn)
     * @param nums
     * @return
     */
    public int maximumProduct(int[] nums) {
        int n = nums.length - 1;
        Arrays.sort(nums);
        int l = nums[0] * nums[1] * nums[n];
        int r = nums[n] * nums[n - 1] * nums[n - 2];
        return Math.max(l, r);
    }

    /**
     * O(n)
     * O(1)
     * @param nums
     * @return
     */
    public int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= min1 && nums[i] < min2) {
                min2 = nums[i];
            } else if (nums[i] < min1) {
                min2 = min1;
                min1 = nums[i];
            }

            if (nums[i] > max3) {
                max1 = max2;
                max2 = max3;
                max3 = nums[i];
            } else if (nums[i] <= max3 && nums[i] > max2) {
                max1 = max2;
                max2 = nums[i];
            } else if (nums[i] <= max2 && nums[i] > max1) {
                max1 = nums[i];
            }
        }

        return Math.max(min1 * min2 * max3, max1 * max2 * max3);
    }
}