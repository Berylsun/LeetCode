//n^3, n^3
class Solution {
    HashMap<Integer, List<String>> map = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s,wordDict, 0);
    }
    
    public List<String> dfs(String s, List<String> wordDict, int start) {
        List<String> res = new ArrayList<>();
        if (map.containsKey(start)) {
            return map.get(start);
        }
        if (start == s.length()) {
            res.add("");
        }
        
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                List<String> list = dfs(s, wordDict, end);
                for (String str : list) {
                    res.add(s.substring(start, end) + (str.equals("") ? "" : " ") + str);
                }
            }
        }
        map.put(start, res);
        return res;
    }
}
