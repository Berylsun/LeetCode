//n, n
public int lengthOfLongestSubstringTwoDistinct(String s) {
    if (s == null || s.length() == 0) return 0;
    int res = 0;
    int start = 0, end = 0;
    int leftmost = s.length();
    HashMap<Character, Integer> map = new HashMap<>();
    while (end < s.length()) {
        if (map.size() <= 2) {
            map.put(s.charAt(end), end);
            end++;
        }
        if (map.size() > 2) {
            for (int num : map.values()) {
                leftmost = Math.min(leftmost, num);
            }
            map.remove(s.charAt(leftmost));
            start = leftmost + 1;
        }
        res = Math.max(res, end - start);
    }
    return res;
}
