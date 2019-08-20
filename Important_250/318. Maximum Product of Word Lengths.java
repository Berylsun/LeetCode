//n^2, n
位运算！！！
class Solution {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) return 0;
        
        int res = 0;
        int[] bytes = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int val = 0;
            for (char c : words[i].toCharArray()) {
                val |= 1 << (c - 'a');
            }
            bytes[i] = val;
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((bytes[i] & bytes[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        
        return res;
    }
}
