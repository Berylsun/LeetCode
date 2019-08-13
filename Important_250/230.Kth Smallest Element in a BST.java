//n,n
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
    //inorder traversal
    int res;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        res = 0;
        count = k;
        helper(root);
        return res;
    }
    
    public void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        count--;
        if (count == 0) {
            res = root.val;
        }
        helper(root.right);
    }
}
