class Solution {
    /**
     * O(1) 26
     * O(1)
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            nums[c - 'a']++;
        }
        char res = ' ';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (nums[c - 'a'] == 1) {
                res = c;
                break;
            }
        }
        return res;
    }


    public char firstUniqChar(String s) {
        Map<Character, Boolean> dic = new LinkedHashMap<>(); // ordered hashmap
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(Map.Entry<Character, Boolean> d : dic.entrySet()){
            if(d.getValue()) return d.getKey();
        }
        return ' ';
    }
}