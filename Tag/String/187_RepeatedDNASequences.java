class Solution {
    /**
     * O(n)
     * O(n)
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Boolean> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 10) return res;
        for (int i = 0; i < s.length() - 9; i++) {
            String str = s.substring(i, i + 10);
            if (map.containsKey(str) && !map.get(str)) {
                res.add(str);
                map.put(str, true);
            } else if (!map.containsKey(str)) {
                map.put(str, false);
            }
        }
        return res;
    }
}