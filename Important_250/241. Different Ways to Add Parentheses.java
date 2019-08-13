//time : O(n^3) 不确定
//space : O(n)
class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> a1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> a2 = diffWaysToCompute(input.substring(i + 1));
                for (int x : a1) {
                    for (int y : a2) {
                        if (c == '+') {
                            res.add(x + y);
                        }else if (c == '-') {
                            res.add(x - y);
                        }else {
                            res.add(x * y);
                        }
                    }
                }
            }
        }
        if (res.size() == 0){
            res.add(Integer.valueOf(input));
        }
        return res;
    }
}
