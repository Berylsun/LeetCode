    // time : O(logn) space : O(1)
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        while (root != null) {
            if (Math.abs(target - root.val) < Math.abs(target - res)) {
                res = root.val;
            }
            root = root.val > target ? root.left : root.right;
        }
        return res;
    }

//logn, n
int res;
public int closestValue(TreeNode root, double target) {
    res = root.val;
    helper(root, target);
    return res;
}

public void helper(TreeNode root, double target) {
    if (root == null) return;
    if (Math.abs(root.val - target) < Math.abs(res - target)) {
        res = root.val;
    }
    if (root.val < target) {
        helper(root.right, target);
    }
    if (root.val > target) {
        helper(root.left, target);
    }
}
