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
    public int read(char[] buf, int n) {
        char[] temp = new char[4];
        int idx = 0;
        while (idx < n) {
            int count = read4(temp);
            if (count == 0) break;
            int num = Math.min(n - idx, count);
            for (int i = 0; i < num; i++) {
                buf[idx++] = temp[i];
            }
        }
        return idx;
    }
}