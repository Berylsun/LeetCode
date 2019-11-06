//logn, 1
public int closestValue(TreeNode root, double target) {
    int res = root.val;
    while (root != null) {
        if (Math.abs(res - target) > Math.abs(root.val - target)) {
            res = root.val;
        }
        root = root.val > target ? root.left : root.right;
    }
    return res;
}


//logn, n
public int closestValue(TreeNode root, double target) {
    return helper(root, target, root.val);
}

public int helper(TreeNode root, int target, int val) {
    if (root == null) return val;
    if (Math.abs(val - target) > Math.abs(root.val - target)) {
        val = root.val;
    }
    if (root.val < target) {
        val = helper(root.right, target, val);
    }else if (root.val > target) {
        val = helper(root.left, target, val);
    }
    return val;
}
