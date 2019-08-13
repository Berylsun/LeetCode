//n, n
PostOrder
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
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
        res = Integer.MIN_VALUE;
        helper(root);
        return res;
    }
    
    public int helper(TreeNode root) {
        if (root == null) return 0;
        int l = Math.max(0, helper(root.left));
        int r = Math.max(0, helper(root.right));
        res = Math.max(res, l + r + root.val);
        return Math.max(l, r) + root.val;
    }
}
