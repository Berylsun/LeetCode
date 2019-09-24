//不知，n
class Solution {
    public String countAndSay(int n) {
        String res = "1";
        for (int i = 1; i < n; i++) {
            int count = 0;
            int idx = 0;
            char c = res.charAt(idx);
            StringBuilder sb = new StringBuilder();
            while (idx < res.length()) {
                while (idx < res.length() && res.charAt(idx) == c) {
                    idx++;
                    count++;
                }
                sb.append(count);
                sb.append(c);
                if (idx < res.length()) {
                    c = res.charAt(idx);
                }
                count = 0;
            }
            res = sb.toString();
        }
        return res;
    }
}

class Solution {
    public String countAndSay(int n) {
        String res = "1";
        int i = 1; //!!!!
        
        while (i < n) { 
            char c = res.charAt(0);
            StringBuilder sb = new StringBuilder();
            int count = 0; //return to zero
            
            for (int j = 0; j <= res.length(); j++) {
                if (j != res.length() && res.charAt(j) == c) {
                    count++;
                }else {
                    sb.append(count);
                    sb.append(c);
                    if (j != res.length()) {
                        c = res.charAt(j);
                    }
                    count = 1;  //!!!
                }
            }
            
            res = sb.toString();
            i++;
        }
        
        return res;
    }
}
