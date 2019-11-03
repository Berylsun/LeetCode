//n
class ValidWordAbbr {
    /*
        don't forget that if the word is the same in dictionary, it is unique
    */
    HashMap<String, String> map;
    String[] dictionary;
    
    public ValidWordAbbr(String[] dictionary) {
        this.dictionary = dictionary;
        map = new HashMap<>();
        for (String s : dictionary) {
            String str = abbr(s);
            if (map.containsKey(str)) {
                //!!! have two more words with same abbr
                if (!map.get(str).equals(s)) {
                    map.put(str, "");
                }
            }else {
                map.put(str, s);
            }
            
        }
    }
    
    public boolean isUnique(String word) {
        String s = abbr(word);
        return !map.containsKey(s) || map.get(s).equals(word);
    }
    
    public String abbr(String s) {
        if (s.length() <= 2) return s;
        String res = "";
        //int to String
        res += s.charAt(0) + Integer.toString(s.length() - 2) + s.charAt(s.length() - 1);
        return res;
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
