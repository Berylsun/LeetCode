//n*k^2, n
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        for (int i = 0; i <words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String a = words[i].substring(0, j);
                String b = words[i].substring(j);
                if (isPalindrome(a)) {
                    String brev = new StringBuilder(b).reverse().toString();
                    if (map.containsKey(brev) && map.get(brev) != i){
                        res.add(Arrays.asList(map.get(brev), i));
                    }
                }
                if (b.length() != 0 && isPalindrome(b)) {
                    String arev = new StringBuilder(a).reverse().toString();
                    if (map.containsKey(arev) && map.get(arev) != i){
                        res.add(Arrays.asList(i,map.get(arev)));
                    }
                }
            }
        }
        return res;                                
    }
    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
}
