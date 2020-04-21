/**
 * O(n)
 * O(n)
 */
class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0) return s;
        if (numRows == 1) return s;
        int n = s.length();
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }
        for (int i = 0; i < n; i++) {
            int num = i % (2 * numRows - 2);
            int idx = num < numRows ? num : 2 * numRows - num - 2;
            sb[idx].append(s.charAt(i));
        }
        for (int i = 1; i < numRows; i++) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}