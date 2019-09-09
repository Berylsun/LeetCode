//BackTracking 
//time : (卡特兰数)O(n!) (2^n)  space : O(n)
// h(n)= h(0)*h(n-1)+h(1)*h(n-2) + ... + h(n-1)h(0) (n>=2)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        //if input is pair, add their numbers.
        helper(res, "", n, n);
        return res;
    }
    
    public void helper(List<String> res, String s, int left, int right) {
        if (left > right) return ; // num of ) > (
        if (left == 0 && right == 0) {
            res.add(s);
        }
        if (left > 0) {
            helper(res, s + "(", left - 1, right);
        }
        if (right > 0) {
            helper(res, s + ')', left, right - 1);
        }
    }
}
