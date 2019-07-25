//n^2, n  !!!remove() O(n)
class Solution {
    public String getPermutation(int n, int k) {
        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = i * fact[i - 1];
        }
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        
        k--; //!!! 
        StringBuilder res = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            int index = k / fact[i];
            k %= fact[i];
            res.append(nums.get(index));
            nums.remove(index);
        }
        return res.toString();
    }
}
