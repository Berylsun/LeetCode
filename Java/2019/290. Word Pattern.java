//O(n^2), space : O(1) (character：256) / O(n)
class Solution {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        String[] strs = str.split(" +");
        if (strs.length != pattern.length()) return false;
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) { //contains 需要O(n)
                if (!map.get(c).equals(strs[i])) return false;
            }else {
                if (map.containsValue(strs[i])) {
                    return false;
                }
                map.put(c, strs[i]);
            }
        }
        return true;
    }
}
