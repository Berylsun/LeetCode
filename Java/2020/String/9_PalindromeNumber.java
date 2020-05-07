class Solution {
    /**
     * O(logn)
     * O(1)
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        int num = x;
        int res = 0;
        while (num != 0) {
            res = res * 10 + num % 10;
            num /= 10;
        }
        return res == x && x >= 0;
    }
}