class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0,i=0,j=0;
        Set<Character> set= new HashSet<>();
        while(j<s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                max=Math.max(max,set.size());
                j++;
            }else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }
}
