class Solution {
    /**
     * O(n)
     * O(n)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            while (map.size() > 2) {
                int value = map.get(s.charAt(j));
                if (value == 1) {
                    map.remove(s.charAt(j));
                } else {
                    map.put(s.charAt(j), value - 1);
                }
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}