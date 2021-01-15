class Solution {
    /**
     * O(n)
     * O(1)
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if (t == null || t.length() == 0) return "";
        int[] count = new int[128];
        for (char c : t.toCharArray()) {
            count[c]++;
        }
        int total = t.length();
        int from = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (count[s.charAt(i)] > 0) total--;
            count[s.charAt(i)]--;
            while (total == 0) {
                if (i - j + 1 < min) {
                    min = i - j + 1;
                    from = j;
                }
                count[s.charAt(j)]++;
                if (count[s.charAt(j)] > 0) {
                    total++;
                }
                j++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(from, from + min);
    }
}