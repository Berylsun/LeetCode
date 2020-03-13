/**
 * time : O(n)
 * space : O(1)
 *
 * PS：这里忽略了equals的时间复杂度，要不equals也是 O(n)
 */

class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int a = -1;
        int b = -1;
        int res = words.length;

        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                if (word1.equals(word2)) {
                    a = b;
                } else {
                    a = i;
                }
            }
            if (word2.equals(words[i])) {
                b = i;
            }
            if (a != -1 && b != -1) {
                res = Math.min(res, Math.abs(a - b));
            }
        }

        return res;
    }
}