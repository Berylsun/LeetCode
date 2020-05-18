class Solution {
    /**
     * O(n)
     * O(n)
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        int[] count = new int[26];
        int total = p.length();
        for (char c : p.toCharArray()) {
            count[c - 'a']++;
        }
        int start = 0;
        int end = 0;
        while (end < s.length()) {
            if (end - start == p.length() && count[s.charAt(start++) - 'a']++ >= 0) {
                total++;
            }
            if (count[s.charAt(end++) - 'a']-- > 0) {
                total--;
            }
            if (total == 0) res.add(start);
        }
        return res;
    }
}