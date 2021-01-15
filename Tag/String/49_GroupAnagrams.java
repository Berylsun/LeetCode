/**
 * time : O(m * n)   m : strs 长度   n : strs中最大String的长度
 * space : O(n) 或者 O(n^2) 结果不同
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) return res;
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String s = sortString(str);
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }
            List<String> list = map.get(s);
            list.add(str);
            map.put(s, list);
        }
        return new ArrayList<>(map.values());
    }
    public static String sortString(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        String res = "";
        for (int i = 0; i < 26; i++) {
            while (count[i] != 0) {
                res += i + 'a';
                count[i]--;
            }
        }
        return res;
    }
}