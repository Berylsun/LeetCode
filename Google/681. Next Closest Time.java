class Solution {
    public String nextClosestTime(String time) {
        char[] res = time.toCharArray();
        char[] digits = new char[]{res[0], res[1], res[3], res[4]};
        Arrays.sort(digits);
        
        //HH:M_
        res[4] = findNext(res[4], '9', digits);
        if (res[4] > time.charAt(4)) return String.valueOf(res);
        
        //HH:_M
        res[3] = findNext(res[3], '5', digits);
        if (res[3] > time.charAt(3)) return String.valueOf(res);
        
        
        //H_:MM
        res[1] = res[0] == '2' ? findNext(res[1], '3', digits) : findNext(res[1], '9', digits);
        if (res[1] > time.charAt(1)) return String.valueOf(res);
        
        //_H:MM
        res[0] = findNext(res[0], '2', digits);
        //23:59 -> 22:22
        return String.valueOf(res);
        
    }
    
    public char findNext(char current, char upperLimit, char[] digits) {
        if (current == upperLimit) {
            return digits[0];
        }
        
        int pos = Arrays.binarySearch(digits, current) + 1;
        while (pos < 4 && (digits[pos] > upperLimit || digits[pos] == current)) {
            pos++;
        }
        
        return pos == 4? digits[0] : digits[pos];
    }
}
