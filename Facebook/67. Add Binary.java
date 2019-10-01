class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int remainder = 0;
        while (i >= 0 || j >= 0) {
            int sum = remainder;
            // - '0' !!!
            if (i >= 0 && a.charAt(i--) - '0' > 0) sum++;
            if (j >= 0 && b.charAt(j--) - '0'> 0) sum++;
            remainder = sum / 2;
            sb.append(sum % 2);
        }
        if (remainder != 0) {
            sb.append(remainder);
        }
        
        return sb.reverse().toString();
    }
}
