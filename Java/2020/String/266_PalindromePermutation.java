class Solution {
    /**
     * O(n)
     * O(1)
     * or use cnt[128]
     * @param s
     * @return
     */
    public boolean canPermutePalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return set.size() == 1 || set.size() == 0;
    }
}