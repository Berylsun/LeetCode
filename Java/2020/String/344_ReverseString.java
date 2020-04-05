/**
 * O(n)
 * O(1)
 */
class Solution {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) return;
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            char c = s[l];
            s[l++] = s[r];
            s[r--] = c;
        }
    }
}