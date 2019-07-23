//不知，n
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
