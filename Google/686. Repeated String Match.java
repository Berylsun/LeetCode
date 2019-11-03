//n, n
class Solution {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb =  new StringBuilder();
        int count = 0;
        
        while (sb.length() < B.length()) {
            sb.append(A);
            count++;
        }
        
        if (sb.indexOf(B) != -1) {
            return count;
        }else if (sb.append(A).indexOf(B) != -1) {
            return count + 1;
        }else {
            return -1;
        }
    }
}
