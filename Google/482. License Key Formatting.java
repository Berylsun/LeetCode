//n, n
class Solution {
    public String licenseKeyFormatting(String S, int K) {
        if (S == null || S.length() == 0) return S;
        
        String s = S.replace("-","");
        s = s.toUpperCase();
        if (K >= s.length()) return s;
        
        StringBuilder res = new StringBuilder();
        int i = s.length() - 1;
        int k = K;
        while (i >= 0) {
            while (k > 0 && i >= 0) {
                res.append(s.charAt(i));
                k--;
                i--;
            }
            if (i >= 0) {
                res.append("-");
            }
            k = K;
        }
        
        return res.reverse().toString();
    }
}





    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--)
            if (s.charAt(i) != '-')
                sb.append(sb.length() % (k + 1) == k ? '-' : "").append(s.charAt(i));
        return sb.reverse().toString().toUpperCase();
    }
