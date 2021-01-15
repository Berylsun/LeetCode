/**
 * O(n * m)
 * O(n)
 */
class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        if (strings == null || strings.length == 0) return new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            String s = helper(str);
            List<String> list = new ArrayList<>();
            if (map.containsKey(s)) {
                list = map.get(s);
            }
            list.add(str);
            map.put(s, list);
        }
        return new ArrayList<>(map.values());
    }

    public String helper(String s) {
        int count = s.charAt(0) - 'a';
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c - 'a' < count) {
                res += 26 + c - count;
            } else {
                res += c - count;
            }
        }
        return res;
    }
}