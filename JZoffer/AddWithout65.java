class Solution {
    /**
     * O(1)
     * O(1)
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            a ^= b; //无进位和
            b = c;  //进位
        }
        return a;
    }
}