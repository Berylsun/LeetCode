//n^3, n
class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        if (input == null || input.length() == 0) return res;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String a = input.substring(0, i);
                String b = input.substring(i + 1);
                List<Integer> a1 = diffWaysToCompute(a);
                List<Integer> b1 = diffWaysToCompute(b);
                for (int x : a1) {
                    for (int y : b1) {
                        if (c == '+') {
                            res.add(x + y);
                        }
                        if (c == '-') {
                            res.add(x - y);
                        }
                        if (c == '*') {
                            res.add(x * y);
                        }
                    }
                }
            }
        }
        if (res.size() == 0) {
            res.add(Integer.valueOf(input));
        }
        return res;
    }
}
