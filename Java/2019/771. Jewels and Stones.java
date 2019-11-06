class Solution {
    public int numJewelsInStones(String J, String S) {
        Set<Character> set= new HashSet<>();
        for(char c:J.toCharArray()){
            set.add(c);
        }
        int res=0;
        for(char a:S.toCharArray()){
            if(set.contains(a)){
                res++;
            }
        }
        return res;
    }
}
