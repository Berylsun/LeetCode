//max(m, n), n
class Solution {
    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            return addBinary(b, a);
        }
        int ai = a.length() - 1;
        int bi = b.length() - 1;
        int remainder = 0;
        StringBuilder sb = new StringBuilder();
        
        while(ai >=0) {
            int sum = 0;
            if (bi >=0) {
                sum = remainder;
                sum += a.charAt(ai) - '0';
                sum += b.charAt(bi) - '0';                
                ai--;
                bi--;
            }else {
                sum += remainder;
                sum += a.charAt(ai) - '0';
                ai--;
            }
            sb.append(sum % 2);
            remainder = sum / 2;
        }
        if (remainder == 1) {
            sb.append(remainder);
        }
        return sb.reverse().toString();
    }
}
