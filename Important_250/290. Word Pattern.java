//n^2, n
class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" +");        
        if (strs.length != pattern.length()) {
            return false;
        }
        
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!map.get(c).equals(strs[i])) return false;
            }else {
                if (map.containsValue(strs[i])) return false;
                map.put(c, strs[i]);
            }
        }
        
        return true;
    }
}
