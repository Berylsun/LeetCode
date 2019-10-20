//m*n, n
class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        int res = 0;
        if (emails == null || emails.length == 0) return 0;
        
        for (int i = 0; i < emails.length; i++) {
            String s = helper(emails[i]);
            if (set.add(s)) {
                res++;
            }
        }
        
        return res;
    }
    
    public String helper(String s) {
        int i = 0;
        String res = "";
        while (i < s.length()) {
            if (s.charAt(i) == '@') {
                break;
            }
            
            if (s.charAt(i) == '.') {
                i++;
                continue;
            }else if (s.charAt(i) == '+') {
                break;
            }else {
                res += s.charAt(i);
                i++;
            }
        }
        
        if (s.charAt(i) == '+') {
            while (s.charAt(i) != '@') {
                i++;
            }
        }
        
        res += s.substring(i);
        
        return res;
    }
}


//n, n

class Solution {
    public int numUniqueEmails(String[] emails) {
        if (emails == null || emails.length == 0) return 0;
        
        HashSet<String> set = new HashSet<>();
        for (String s : emails) {
            String[] s1 = s.split("@");
            String[] s2 = s1[0].split("\\+");   //"\\+" 解析+
            String str = s2[0].replace(".", "") + "@" + s1[1];
            set.add(str);
        }
        
        return set.size();
    }
}
