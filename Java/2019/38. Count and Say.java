//no known, n
class Solution {
    public String countAndSay(int n) {
        String res = "1";                
        for (int i = 2; i <= n; i++) {
            int count = 0;
            StringBuilder sb = new StringBuilder();
            char c = res.charAt(0);
            for (int j = 0; j <= res.length(); j++) {
                if (j < res.length() && res.charAt(j) == c) {
                    count++;
                }else {
                    sb.append(count);
                    sb.append(c);
                    if (j < res.length()) {
                        c = res.charAt(j);
                        count = 1;
                    }
                }                
            }
            res = sb.toString();
        }
        return res;
    }
}
