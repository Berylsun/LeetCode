class Solution {
    /**
     * O(max(m, n))
     * O(J.lengh())
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones(String J, String S) {
        int res = 0;
        HashSet<Character> set = new HashSet<>();
        for (char c : J.toCharArray()) {
            set.add(c);
        }
        for (char c : S.toCharArray()) {
            if (set.contains(c)) {
                res++;
            }
        }
        return res;
    }
}