Binary Index Tree !!!
class NumArray {
    int[] tree;
    int n;
    int[] arr;
    // time : O(n * logn)
    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[n + 1];
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            update(i, nums[i]);
        }
    }
    
    // time : O(logn)
    public void update(int i, int val) {
        if (n == 0) return;
        int diff = val - arr[i];
        arr[i] = val;
        
        for (int j = i + 1; j <= n; j += j & (-j)) {
            tree[j] += diff;
        }
    }
    
    // time : O(logn)
    private int sum (int num) {
        int res = 0;
        for (int i = num; i > 0; i -= i & (-i)) {
            res += tree[i];
        }
        return res;
    }
    
    public int sumRange(int i, int j) {
        return sum(j + 1) - sum(i);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
