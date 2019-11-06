//n, n postorder
public List<List<Integer>> findLeaves(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;
    helper(res, root);
    return res;
}

public int helper(List<List<Integer>> res, TreeNode root) {
    if (root == null) return -1;
    int left = helper(res, root.left);
    int right = helper(res, root.right);
    int level = Math.max(left, right) + 1;
    if (level == res.size()) {
        res.add(new ArrayList<>());
    }
    res.get(level).add(root.val);
    root.left = null;
    root.right = null;
    return level;
}
