//不知道，n
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) return res;
        helper(res, num, target, "", 0, 0, 0);
        return res;
    }
    
    public void helper(List<String> res, String num, int target, String s, int pos, long val, long pre) {
        if (pos == num.length()) {
            if (val == target) {
                res.add(s);
                return;
            }            
        }else {
            for (int i = pos; i < num.length(); i++) {
                if (i != pos && num.charAt(pos) == '0') break;
                long temp = Long.parseLong(num.substring(pos, i + 1));
                if (pos == 0) {
                    helper(res, num, target, s + temp, i + 1, temp, temp);
                }else {
                    helper(res, num, target, s + "+" + temp, i + 1, val + temp, temp);
                    helper(res, num, target, s + "-" + temp, i + 1, val - temp, -temp);
                    helper(res, num, target, s + "*" + temp, i + 1, val - pre + pre * temp, pre * temp);
                }
            }
        }
    }
}
