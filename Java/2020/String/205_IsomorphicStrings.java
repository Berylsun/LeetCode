/**
 * O(n^2)
 * O(n)
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else if (map.containsValue(t.charAt(i))) { //O(n)
                return false;
            } else {
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
}

/**
 * O(n)
 * O(1)
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] sl = new int[256];
        int[] tl = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (sl[s.charAt(i)] != tl[t.charAt(i)]) {
                return false;
            }
            sl[s.charAt(i)] = tl[t.charAt(i)] = t.charAt(i);
        }
        return true;
    }
}