
class Solution {
    /**
     * O(n)
     * O(n)
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) return s;
        HashMap<Character, Integer> map =  new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        int start = 0;
        int end = findLast(map);
        char[] res = new char[map.size()];
        for (int i = 0; i < res.length; i++) {
            char minchar = 'z' + 1;
            for (int k = start; k <= end; k++) {
                if (map.containsKey(s.charAt(k)) && s.charAt(k) < minchar) {
                    minchar = s.charAt(k);
                    start = k + 1;
                }
            }
            res[i] = minchar;
            map.remove(minchar);
            if (s.charAt(end) == minchar) {
                end = findLast(map);
            }
        }
        return new String(res);
    }

    public int findLast(HashMap<Character, Integer> map) {
        int res = Integer.MAX_VALUE;
        for (int num : map.values()) {
            res = Math.min(res, num);
        }
        return res;
    }
}