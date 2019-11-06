//2^n不确定, 2^n
public boolean canWin(String s) {
    if (s == null || s.length() == 0) return false;
    HashMap<String, boolean> map = new HashMap<>();
    return helper(s, map);
}

public boolean helper(String s, HashMap<String, boolean> map) {
    if (map.containsKey(s)) return map.get(s);
    for (int i = 0; i < s.length() - 1; i++) {
        if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
            String opponent = s.substring(0, i) + "--" + s.substring(i + 2);
            if (!helper(opponent, map)) {
                map.put(s, true);
                return true;
            }
        }
    }
    map.put(s, false);
    return false;
}
