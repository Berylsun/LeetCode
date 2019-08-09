//logn, n
class Solution {
    public String convertToTitle(int n) {
        String res = "";
        if (n <= 0) return res;
        while (n != 0) {
            res = (char)((n - 1) % 26 + 'A') + res;
            n = (n - 1) / 26;
        }
        
        return res;
    }
}
