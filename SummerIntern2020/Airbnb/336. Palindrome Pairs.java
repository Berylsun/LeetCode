//time : O(n * k^2)

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length < 2) return res;
        
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String s1 = words[i].substring(0, j);
                String s2 = words[i].substring(j);
                if (isPalindrome(s1)) {
                    String s2rev = new StringBuilder(s2).reverse().toString();
                    if (map.containsKey(s2rev) && map.get(s2rev) != i) {
                        res.add(Arrays.asList(map.get(s2rev), i));
                    }
                }
                
                /*
                !!! s2.length() != 0 ->
                      ["abcd","dcba","lls","s","sssll"]->
                        [[1,0],[0,1],[0,1],[1,0],[3,2],[2,4]] !!!
                */
                if (s2.length() != 0 && isPalindrome(s2)) {
                    String s1rev = new StringBuilder(s1).reverse().toString();
                    if (map.containsKey(s1rev) && map.get(s1rev) != i) {
                        res.add(Arrays.asList(i, map.get(s1rev)));
                    }
                }
            }
        }
        
        return res;
    }
    
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}
