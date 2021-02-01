class Solution {
    /**
     * O(2^n)
     * O(n)
     */
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        helper(new ArrayList<>(), s);
        return res;
    }

    public void helper(List<String> list, String s) {
        if (s.length() == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(0, i + 1);
            if (isPalindrome(str)) {
                list.add(str);
                helper(list, s.substring(i + 1));
                list.remove(list.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}