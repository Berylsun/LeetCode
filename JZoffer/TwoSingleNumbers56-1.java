class Solution {
    /**
     * O(n)
     * O(1)
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        int[] res = new int[2];
        int num = 0;
        for (int n : nums) {
            num ^= n;
        }
        int d = 1;
        while ((d & num) == 0) {
            d <<= 1;
        }

        int a = 0;
        int b = 0;
        for (int n : nums) {
            if ((n & d) == 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        res[0] = a;
        res[1] = b;
        return res;
    }
}