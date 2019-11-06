//n, n inorder
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int res;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        res = 0;
        count = k;
        if (root == null) return 0;
        helper(root);
        return res;
    }
    
    public void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        count--;
        if (count == 0) {
            res = root.val;
            return;
        }
        helper(root.right);
    }
}
