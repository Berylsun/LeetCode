/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /**
     * O(n)
     * O(n)
     */
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
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