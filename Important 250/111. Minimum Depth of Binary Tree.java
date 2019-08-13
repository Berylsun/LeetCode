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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        if (root.left == null || root.right == null) {
            return root.left == null ? r + 1 : l + 1;
        }
        return 1 + Math.min(l, r);
    }
}111. Minimum Depth of Binary Tree
