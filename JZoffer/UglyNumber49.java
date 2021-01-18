class Solution {
    /**
     * O(n)
     * O(n)
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int i = 1;
        while (i < n) {
            int min = Math.min(nums[index2] * 2, Math.min(nums[index3] * 3, nums[index5] * 5));
            if (nums[index2] * 2 == min) index2++;
            if (nums[index3] * 3 == min) index3++;
            if (nums[index5] * 5 == min) index5++;
            nums[i] = min;
            i++;
        }
        return nums[n - 1];
    }
}