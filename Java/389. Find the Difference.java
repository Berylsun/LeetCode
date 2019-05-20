class Solution {
    public char findTheDifference(String s, String t) {
        int ssum = 0;
        int tsum = 0;
        for (int i = 0; i < s.length(); i++) {
            ssum += s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            tsum += t.charAt(i);
        }
        return (char) (tsum - ssum);
    }
}


//O(n), O(1)
class Solution {
    public char findTheDifference(String s, String t) {
        char c = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        return  c;
    }
}
