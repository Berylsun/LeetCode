//n, n
public TreeNode upsideDownBinaryTree(TreeNode root) {
    if (root == null || root.right == null && root.left) return root;
    TreeNode newRoot = upsideDownBinaryTree(root.left);
    root.left.left = root.right;
    root.left.right = root;
    
    root.right = null;
    root.left = null;
    return newRoot;
}
