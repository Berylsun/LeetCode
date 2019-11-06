//O(3^4) => O(1) => O(3^n), n
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        helper(res, s, "", 0, 0);
        return res;
    }
    
    public void helper(List<String> res, String s, String ret, int index, int count) {
        if (count > 4) return;
        if (count == 4 && index == s.length()) {
            res.add(ret);
            return;
        }
        for (int i = 1; i < 4; i++) {
            if (index + i > s.length()) break;
            String temp = s.substring(index, index + i);
            if ((temp.startsWith("0") && temp.length() > 1) || Integer.parseInt(temp) > 255) continue;
            helper(res, s, ret + temp + (count == 3 ? "" : "."), index + i, count + 1);
        }
        
    }
}
