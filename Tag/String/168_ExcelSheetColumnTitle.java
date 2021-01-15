class Solution {
    /**
     * O(logn)
     * O(n)
     * @param n
     * @return
     */
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            char re = (char)((n - 1) % 26 + 'A'); // !!!!
            sb.append(re);
            n = (n - 1) / 26;
        }
        return sb.reverse().toString();
    }
}