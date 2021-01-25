class Solution {
    /**
     * O(n)
     * O(1)
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int count = 0;
        int res = 0;
        for (int n : nums) {
            if (count == 0) {
                res = n;
            }
            if (res == n) {
                count++;
            } else {
                count--;
            }
        }
        return res;
    }
}