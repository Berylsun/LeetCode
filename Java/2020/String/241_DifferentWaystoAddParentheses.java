class Solution {
    /**
     * O(n^3)
     * O(n)
     * @param input
     * @return
     */
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> l1s = diffWaysToCompute(input.substring(0, i));
                List<Integer> l2s = diffWaysToCompute(input.substring(i + 1));
                for (int l1 : l1s) {
                    for (int l2 : l2s) {
                        if (c == '+') {
                            res.add(l1 + l2);
                        } else if (c == '-') {
                            res.add(l1 - l2);
                        } else {
                            res.add(l1 * l2);
                        }
                    }
                }
            }
        }
        if (res.size() == 0) {
            res.add(Integer.parseInt(input));
        }
        return res;
    }
}