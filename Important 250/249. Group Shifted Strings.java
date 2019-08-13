//m * n, n
/*
 For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
     A solution is:

     [
     ["abc","bcd","xyz"],
     ["az","ba"],
     ["acef"],
     ["a","z"]
     ]
*/
public List<List<String>> groupStrings(String[] strings) {
    List<List<String>> res = new ArrayList<>();
    HashMap<String, List<String>> map = new HashMp<>();
    for (String s : strings) {
        int offset = s.charAt(0) - 'a';
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            char c = (char)(s.charAt(i) - offset);
            if (c < 'a') {
                c += 26;
            }
            str += c;
        }
        
        if (map.containsKey(str)) {
            map.get(str).add(s);
        }else {
            List<String> list = new ArrayList<>();
            list.add(s);
            map.put(str, list);
        }
    }
    
    for (String key : map.keySet()) {
        List<String> list = map.get(key);
        res.add(list);
    }
    
    return res;
}
