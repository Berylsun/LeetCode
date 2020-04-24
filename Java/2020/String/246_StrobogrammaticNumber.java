class Solution {
    /**
     * O(n)
     * O(n)
     * @param num
     * @return
     */
    public boolean isStrobogrammatic(String num) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('6', '9');
        map.put('8', '8');
        map.put('1', '1');
        map.put('9', '6');
        map.put('0', '0');
        int l = 0;
        int r = num.length() - 1;
        while (l <= r) {
            char cl = num.charAt(l);
            char cr = num.charAt(r);
            if (!map.containsKey(cl)) {
                return false;
            }
            if (map.get(cl) != cr) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}