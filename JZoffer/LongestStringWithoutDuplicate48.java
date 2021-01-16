class Solution {
    /**
     * O(n^2)
     * O(n)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int l = 0;
        int len = s.length();
        int res = 1;
        while (l < len) {
            HashSet<Character> set = new HashSet<>();
            for (int i = l; i < len; i++) {
                if (!set.add(s.charAt(i))) {
                    break;
                }
                res = Math.max(res, i - l + 1);
            }
            l++;
        }
        return res;
    }

    /**
     * O(n)
     * O(n)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 1;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                l = Math.max(map.get(s.charAt(i)) + 1, l);
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - l + 1);
        }
        return res;
    }
}