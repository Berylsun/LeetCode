// 2^n unknown, n
BackTracking!!!
public boolean wordPatternMatch(String pattern, String str) {
    HashMap<Character, String> map = new HashMap<>();
    HashSet<String> set = new HashSet<>(); //values
    return helper(pattern, 0, str, 0, map, set);
}

public boolean helper(String pattern, int i, String str, int j, HashMap<Character, String> map, HashSet<String> set) {
    if (i == pattern.length() && j == str.length()) return true;
    if (i == pattern.length() || j == str.length()) return false;
    
    char c = pattern.charAt(i);
    if (map.containsKey(c)) {
        String s = map.get(c);
        if (!str.startWith(s, j)) {
            return false;
        }
        return helper(pattern, i + 1, str, j + s.length(), map, set);
    }
    
    
    // !map.containsKey(c);
    for (int k = j; j < str.length(); j++) {
        String s = str.substring(j, k + 1);
        if (set.contains(s)) continue;
        map.put(c, s);
        set.add(s);
        if (helper(pattern, i + 1, str, k + 1, map, set)) {
            return true;
        }
        map.remove(c);
        set.remove(s);
    }
    
    return false;
}
