//O(1<<n), O(1<<n)
class Solution {
    public List<Integer> grayCode(int n) {
        //G(i) = i ^ (i / 2);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            res.add(i ^ i >> 1) ;
        }
        return res;
    }
}
