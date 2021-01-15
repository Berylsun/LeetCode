/**
 * O(n)
 * O(1)
 */
class Solution {
    public char findTheDifference(String s, String t) {
        char c = t.charAt(t.length() - 1);
        for (int i = 0 ; i < s.length(); i++) {
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        return c;
    }

    public char findTheDifference(String s, String t) {
        int[] counts = new int[26];
        for (int i = 0; i < t.length(); i++) {
            if (i < s.length()) {
                counts[s.charAt(i) - 'a']++;
            }
            counts[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (counts[i] != 0) {
                return (char)(i + 'a');
            }
        }
        return '0';
    }
}