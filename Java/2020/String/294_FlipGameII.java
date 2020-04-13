/**
 * time : O(2^N) 不确定
 * space : O(2^N)
 */
class Solution {
    public boolean canWin(String s) {
        if (s == null || s.length() == 0) return false;
        HashMap<String, Boolean> map = new HashMap<>();
        return helper(s, map);
    }

    public boolean helper(String s, HashMap<String, Boolean> map) {
        if (map.containsKey(s)) return map.get(s);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
                String cur = s.substring(0, i - 1) + "--" + s.substring(i + 1);
                if (!helper(cur, map)) {
                    map.put(s, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }
}