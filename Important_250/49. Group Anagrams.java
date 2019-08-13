//   time : O(m * n)   m : strs 长度   n : strs中最大String的长度
//   space : O(n) 或者 O(n^2) 结果不同
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            int[] count = new int[26];
            // record elements
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            //mark them and put it to HashMap
            String s = "";
            for (int i = 0; i < 26; i++) {
                if (count[i] != 0) {
                    s += String.valueOf(count[i]) + String.valueOf((char)(i + 'a'));  //二选一加String.valueOf
                }
            }
            if (map.containsKey(s)) {
                List<String> list = map.get(s);
                list.add(str);
            }else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(s, list);
            }            
        }
        
        return new ArrayList<>(map.values());
    }
}
