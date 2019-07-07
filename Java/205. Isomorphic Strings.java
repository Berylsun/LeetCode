//n^2(map.contains O(n)), 1(256)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map= new HashMap<>();
        for (int i=0;i<s.length();i++){
            char a=s.charAt(i);
            char b=t.charAt(i);
            if (map.containsKey(a)){
                if (!map.get(a).equals(b)){
                    return false;
                }
            }else{
                if(!map.containsValue(b)){    // like ab->aa
                    map.put(a,b);
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}

// time : O(n) space : O(1)
    public boolean isIsomorphic2(String s, String t) {
        int[] sChars = new int[256];
        int[] tChars = new int[256];

        for (int i = 0; i < s.length(); i++) {
            if (sChars[s.charAt(i)] != tChars[t.charAt(i)]) {
                return false;
            } else {
                sChars[s.charAt(i)] = tChars[t.charAt(i)] = t.charAt(i);
            }
        }

        return true;
    }
