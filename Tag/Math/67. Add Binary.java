class Solution {
    /**
     * O(max(a, b))
     * O(1)
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int num = 0;
        while (i >= 0 || j >= 0) {
            if (i >= 0) num += a.charAt(i--) - '0';
            if (j >= 0) num += b.charAt(j--) - '0';
            sb.append(num % 2);
            num /= 2;
        }
        if (num > 0) sb.append(num);
        return sb.reverse().toString();
    }
}