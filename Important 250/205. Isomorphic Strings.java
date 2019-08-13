//n^2, n
class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        int i = 0;
        while (i < s.length()) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            }else {
                if (map.containsValue(t.charAt(i))) return false;
                map.put(s.charAt(i), t.charAt(i));
            }
            i++;
        }
        
        return i == t.length();
    }
}

//n, 1
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] sChar = new int[128];
        int[] tChar = new int[128];
        
        for (int i = 0; i < s.length(); i++) {
            if (sChar[s.charAt(i)] != tChar[t.charAt(i)]) return false;
            sChar[s.charAt(i)] = tChar[t.charAt(i)] = t.charAt(i);
        }
        
        return true;
    }
}
