//n, h
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while (root != null) {
            if (root.val <= p.val) {
                root = root.right;
            } else {
                res = root;
                root = root.left;
            }
        }
        return res;
    }
    
public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    if (root == null) return null;
    if (root.val <= p.val) {
        return inorderSuccessor(root.right, p);   
    }else {
        TreeNode temp =  inorderSuccessor(root.left, p);
        return (temp == null) ? root : temp;
    }
}
