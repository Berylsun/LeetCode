//2^n unknown, 2^n
HashMap 为了节省时间

public boolean canWin(String s) {
    if (s == null || s.length() == 0) return false;
    HashMap<String, boolean> map = new HashMap<>();
    return helper(map, s);
}

public boolean helper(HashMap<String, boolean> map, String s) {
    if (map.containsKey(s)) {
        return map.get(s);
    }
    for (int i = 0; i < s.length() - 1; i++) {
        if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
            String str = s.substring(0, i) + '--' + s.substring(i + 2);
            if (!helper(map, s)) {
                map.put(s, true);
                return true;
            }
        }
    }
    
    map.put(s, false);
    return false;
}
