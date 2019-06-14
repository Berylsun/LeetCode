//m*n, n
public List<List<String>> groupStrings(String[] strings) {
    List<List<String>> res = new ArrayList<>();
    HashMap<String, List<String>> map = new HashMap<>();
    int offset = 0;
    for (String s : strings) {
        offset = s.charAt[0] - 'a';
        String key = ""; 
        for (int j = 0; j < s.length(); j++) {
            char c = (char)(s.charAt(i) - offset);
            if (c < 'a') {
                c += 26;
            }
            key += c;
        }
        if (!map.containsKey(key)) {
            List<String> list = new ArrayList<>();
            map.put(key, list);
        }
        map.get(key).add(str);
    }
    for (String key : map.keySet()) {
        List<String> list = map.get(key);
        res.add(list);
    }
    return res;
}
