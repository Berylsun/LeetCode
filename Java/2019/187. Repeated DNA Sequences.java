//n, n
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> repeat = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String temp = s.substring(i, i + 10);
            if (!set.add(temp)) {
                repeat.add(temp);
            }
        }
        return new ArrayList<>(repeat);
    }
}
