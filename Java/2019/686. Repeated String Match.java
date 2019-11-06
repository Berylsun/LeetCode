//Wow~
class Solution {
    public int repeatedStringMatch(String A, String B) {
        
        StringBuilder sb = new StringBuilder();
        int res = 0;
        
        while (sb.length() < B.length()) {
            sb.append(A);
            res++;
        }
        
        if (sb.toString().contains(B)) return res;
        if (sb.append(A).toString().contains(B)) return res + 1;
        return -1;
    }
}
