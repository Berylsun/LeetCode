class Solution {
    /**
     * O(n)
     * O(1)
     *
     * We can also solve this by using HashMap and Arrays.sort()
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int count = 0;
        int res = 0;
        for (int num : nums) {
            if (count == 0) {
                res = num;
            }
            if (num != res) {
                count--;
            } else {
                count++;
            }
        }
        return res;
    }
}