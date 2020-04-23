class Solution {
    /**
     * O(n)
     * O(1)
     * we can also use hashmap to record them, but it will need more space
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = toNumber(s.charAt(0));
        int i = 1;
        while (i < s.length()) {
            char c = s.charAt(i);
            char pre = s.charAt(i - 1);
            int num = toNumber(c);
            int prenum = toNumber(pre);
            if (num > prenum) {
                res -= 2 * prenum;
            }
            res += num;
            i++;
        }
        return res;
    }
    public int toNumber(char c) {
        int res = 0;
        switch(c) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
        }
        return res;
    }
}