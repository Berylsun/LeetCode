// 3^n, n
class Solution {
    String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        helper(res, digits, "", 0);
        return res;
    }
    
    public void helper(List<String> res, String digits, String s, int index) {
        if (index == digits.length()) {
            res.add(s);
            return;
        }
        String letter = mapping[digits.charAt(index) - '0'];
        for (int i = 0; i < letter.length(); i++) {
            helper(res, digits, s + letter.charAt(i), index + 1);
        }
    }
}

class Solution {    
    public List<String> letterCombinations(String digits) {
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> res = new LinkedList<>();
        if (digits == null || digits.length() == 0) return res;
        res.add("");
        for (int i = 0; i <digits.length(); i++) {
            int num = digits.charAt(i) - '0';
            while (res.peek().length() == i) {
                String t = res.remove();
                for (char c : mapping[num].toCharArray()) {
                    res.add(t + c);
                }
            }
        }
        return res;
    }
}
