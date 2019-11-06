    HashMap<String, String> map;
    //n, n
    public _288_UniqueWordAbbreviation(String[] dictionary) {
        map = new HashMap<>();
        for (String s : dictionary) {
            String key = getKey(s);
            if (map.containsKey(key)){
                if (!map.get(key).equals(s)) {
                    map.put(key, "");
                }
            }else {
                map.put(key, s);
            }
        }
    }

    public boolean isUnique(String word) {
        return !map.containsKey(getKey(word)) || map.get(getKey(word)).equals(word);
    }
    
    public String getKey(String s) {
        if (s == null || s.length() <= 2) {
            return s;
        }
        return s.charAt(0) + Integer.toString(s.length() - 2) + s,charAt(s.length() - 1);
    }
