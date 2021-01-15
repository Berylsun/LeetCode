class Solution {
    /**
     * O(n)
     * O(n)
     * @param s1
     * @param s2
     * @return
     */
    // same with LC438
    public boolean checkInclusion(String s1, String s2) {
        if (s2 == null || s2.length() == 0) return false;
        int[] count = new int[26];
        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }
        int end = 0;
        int start = 0;
        int total = s1.length();
        while (end < s2.length()) {
            if (end - start == s1.length() && count[s2.charAt(start++) - 'a']++ >= 0) {
                total++;
            }
            if (--count[s2.charAt(end++) - 'a'] >= 0) {
                total--;
            }
            if (total == 0) return true;
        }
        return false;
    }
}