class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        char[] charArray = s.toCharArray();
        helper(res, charArray, 0);
        return res;
    }

    public void helper(List<String> res, char[] charArray, int start) {
        if (start == charArray.length) {
            res.add(new String(charArray));
            return;
        }
        char c = charArray[start];
        helper(res, charArray,start + 1);
        if (Character.isLetter(c)){
            charArray[start] = change(c);
            helper(res, charArray,start + 1);
        }
    }

    public char change(char c) {
        if (c <= 'z' && c >= 'a') {
            return (char)(c - 'a' + 'A');
        }
        return (char)(c - 'A' + 'a');
    }
}