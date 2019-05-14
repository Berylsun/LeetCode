class Solution {
    public int romanToInt(String s) {
        HashMap <Character, Integer> map = new HashMap<>();
        map.put ('I',1);
        map.put ('V',5);
        map.put ('X', 10);
        map.put ('L', 50);
        map.put ('C', 100);
        map.put ('D', 500);
        map.put ('M', 1000);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))){
                sum += map.get(s.charAt(i + 1)) - map.get(s.charAt(i));
                i++;
            }else {
                sum += map.get(s.charAt(i));
            }
        }
        return sum;
    }
}



class Solution {
    public static int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = toNumber(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (toNumber(s.charAt(i)) > toNumber(s.charAt(i - 1))) {
                res += toNumber(s.charAt(i)) - 2 * toNumber(s.charAt(i - 1));
            } else {
                res += toNumber(s.charAt(i));
            }
        }
        return res;
    }

    public static int toNumber(char c) {
        int res = 0;
        switch (c) {
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
