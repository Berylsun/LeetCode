class Solution {
    /**
     * O(2^n)
     * O(n)
     * !!! not remove(str) but remove(list.size() - 1) because remove the first same element
     * res.add(new ArrayList<>(list))
     */
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        helper(s, new ArrayList<>());
        return res;
    }

    public void helper(String s, List<String> list) {
        if (s.length() == 0) {
            res.add(new ArrayList<>(list)); //!!!!!!
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String str = s.substring(0, i);
            if (isPalindrome(str)) {
                list.add(str);
                helper(s.substring(i), list);
                list.remove(list.size() - 1); //!!! not remove(str) but remove(list.size() - 1)
            }
        }
    }
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}