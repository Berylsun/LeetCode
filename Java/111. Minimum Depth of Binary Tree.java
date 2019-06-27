//n, n
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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.right == null || root.left == null) {
            return Math.max(minDepth(root.right), minDepth(root.left)) + 1;
        }
        return Math.min(minDepth(root.right), minDepth(root.left)) + 1;
    }
}
