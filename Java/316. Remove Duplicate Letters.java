//n, n
class Solution {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) return s;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        char[] res = new char[map.size()];
        int start = 0;
        int end = findMin(map);
        for (int i = 0; i < res.length; i++) {
            char c = 'z' + 1;
            for (int k = start; k <= end; k++) {            
                if (map.containsKey(s.charAt(k)) && s.charAt(k) < c) {
                    c = s.charAt(k);
                    start = k + 1;
                }
            }
            res[i] = c;
            map.remove(c);
            if (s.charAt(end) == c) {
                end = findMin(map);
            }
        }
        return new String(res);
        
    }
    
    
    public int findMin(HashMap<Character, Integer> map) {
        int res = Integer.MAX_VALUE;
        for (int val : map.values()) {
            res = Math.min(res, val);
        }
        return res;
    }
}
