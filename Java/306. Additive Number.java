class Solution {
    public boolean isAdditiveNumber(String num) {
        // i < num.length / 2;
        // max(i,j) < num.length - i - j;
        for (int i = 1; i <= num.length() / 2; i++) {
            for (int j = 1; Math.max(i,j) <= num.length() - i - j; j++) {
                if (isValid(i, j, num)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    
    public boolean isValid(int i, int j, String num) {
        if (num.charAt(0) == '0' && i > 1) return false;
        if (num.charAt(i) == '0' && j > 1) return false;
        Long x1 = Long.parseLong(num.substring(0, i)); 
        //这里为Long类，不是long基本数据类型
        Long x2 = Long.parseLong(num.substring(i, i + j));
        String sum = "";
        for (int start = i + j; start < num.length(); start += sum.length()) {
            x2 = x2 + x1;
            x1 = x2 - x1;
            sum = x2.toString();
            if (!num.startsWith(sum, start)) { 
                //startswith()方法用于检查字符串是否是以指定子字符串开头
                return false;
            }
        }
        return true;
    }
}
