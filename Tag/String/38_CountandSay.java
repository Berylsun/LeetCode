/**
 * unknown
 * O(n)
 */
class Solution {
    public String countAndSay(int n) {
        String res = "1";
        for (int j = 1; j < n; j++) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            int count = 0;
            char c = res.charAt(0);
            while (i < res.length()) {
                while (i < res.length() && res.charAt(i) == c) {
                    i++;
                    count++;
                }
                if (count != 0) {
                    sb.append(count);
                    sb.append(c);
                }
                if (i < res.length()) {
                    c = res.charAt(i);
                }
                count = 0;
            }
            res = sb.toString();
        }
        return res;
    }
}