//3^n, n
class Solution {
    String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        helper (res, digits, "", 0);
        return res;
    }
    
    public void helper(List<String> res, String digits, String s, int index) {
        if (index == digits.length()) { // !!!
            res.add(s);
            return;
        }
        String str = mapping[digits.charAt(index) - '0'];
        for (int i = 0; i < str.length(); i++) {
            helper(res, digits, s + str.charAt(i), index + 1);
        }
    }
}

class Solution {
    String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if (digits == null || digits.length() == 0) return res;
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            String str = mapping[digits.charAt(i) - '0'];
            while (res.peek().length() == i) {
                String temp = res.remove();
                for (int j = 0; j < str.length(); j++) {
                    res.add(temp + str.charAt(j));
                }
            }
            
        }
        return res;
    }
}
