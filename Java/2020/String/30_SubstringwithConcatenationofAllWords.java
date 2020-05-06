class Solution {
    /**
     * O(n^2)
     * O(n)
     */
    int len = 0;
    int n = 0;
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words == null || words.length == 0 || s == null || s.length() == 0) return res;
        len = words[0].length();
        n = words.length;
        int i = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        while (i < s.length() - n * len + 1) {
            if (helper(s, i, map)) {
                res.add(i);
            }
            i++;
        }
        return res;
    }

    public boolean helper(String s, int idx, HashMap<String, Integer> map) {
        HashMap<String, Integer> copy = new HashMap<>(map); // copy!!!
        s = s.substring(idx, idx + n * len);
        for (int i = 0; i < s.length(); i += len) {
            if (copy.containsKey(s.substring(i, i + len))) {
                int value = copy.get(s.substring(i, i + len)) - 1;
                if (value == 0) {
                    copy.remove(s.substring(i, i + len));
                } else {
                    copy.put(s.substring(i, i + len), value);
                }
            } else {
                return false;
            }
        }
        return true;
    }
}