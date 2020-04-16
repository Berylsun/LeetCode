class Solution {
    public String stringShift(String s, int[][] shift) {
        if (s == null || s.length() == 0) return s;
        for (int i = 0; i < shift.length; i++) {
            s = helper(s,shift[i]);
        }
        return s;
    }

    public String helper(String s, int[] nums) {
        int dir = nums[0];
        int amount = nums[1];
        StringBuilder res = new StringBuilder();
        if (dir == 1) {
            res.append(s.substring(s.length() - amount) + s.substring(0, s.length() - amount));
        } else {
            res.append(s.substring(amount) + s.substring(0, amount));
        }
        return res.toString();
    }
}