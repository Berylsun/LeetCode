class Solution {
    /**
     * O(max(len1, len2))
     * O(n)
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0) return num2;
        if (num2 == null || num2.length() == 0) return num1;
        int up = 0;
        int idx1 = num1.length() - 1;
        int idx2 = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (idx1 >= 0 || idx2 >= 0) {
            if (idx1 >= 0) {
                up += num1.charAt(idx1) - '0';
                idx1--;
            }
            if (idx2 >= 0) {
                up += num2.charAt(idx2) - '0';
                idx2--;
            }
            sb.append(up % 10);
            up /= 10;
        }
        if (up != 0) {
            sb.append(up);
        }
        return sb.reverse().toString();
    }
}