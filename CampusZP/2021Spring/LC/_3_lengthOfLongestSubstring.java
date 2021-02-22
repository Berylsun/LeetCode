class Solution {
    /**
     * O(n)
     * O(n)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int res = 0;
        int start = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }
            res = Math.max(res, i - start + 1);
            map.put(c, i);
        }
        return res;
    }
}