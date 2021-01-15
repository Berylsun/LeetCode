/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */

public class Solution extends Reader4 {
    /**
     * O(n)
     * O(1)
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    private int count = 0;
    private int p = 0;
    private char[] temp = new char[4];
    public int read(char[] buf, int n) {
        int idx = 0;
        while (idx < n) {
            if (p == 0) {
                count = read4(temp);
            }
            if (count == 0) break;
            while (idx < n && p < count) {
                buf[idx++] = temp[p++];
            }
            if (p == count) p = 0;
        }
        return idx;
    }
}