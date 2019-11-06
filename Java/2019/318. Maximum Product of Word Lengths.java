class Solution {
    public int maxProduct(String[] words) {
        int[] bytes = new int[words.length];
        int res = 0;
        for (int i = 0; i < words.length; i++) {
           int val = 0;
            for (int j = 0; j < words[i].length(); j++) {
                // 1 << 0 ->0001; 1 << 1 ->0010; 1 << 2 ->0100 ……
                val |= 1 << (words[i].charAt(j) - 'a'); 
            }
            bytes[i] = val;
        }
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((bytes[i] & bytes[j]) == 0) {     //if they share common letter, there must be nonzero.
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}
