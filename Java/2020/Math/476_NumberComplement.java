class Solution {
    /**
     * O(1)
     * O(1)
     * @param num
     * @return
     */
    public int findComplement(int num) {
        int sum = 0;
        while (sum < num) {
            sum = (sum << 1) | 1;
        }
        return sum - num;
    }
}