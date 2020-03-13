//O(n), O(1)
class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int a = -1;
        int b = -1;
        int res = words.length;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                a = i;
            }
            if (word2.equals(words[i])) {
                b = i;
            }
            if (a != -1 && b != -1) {
                res = Math.min(Math.abs(a - b), res);
            }
        }
        return res;
    }
}