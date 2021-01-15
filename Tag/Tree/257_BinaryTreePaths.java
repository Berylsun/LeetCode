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
    List<String> res;
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        if (root == null) return res;
        helper(root, "");
        return res;
    }

    public void helper(TreeNode node, String s) {
        if (node.left == null && node.right == null) {
            res.add(s + node.val);
            return;
        }
        if (node.left != null) {
            helper(node.left, s + node.val + "->");
        }
        if (node.right != null) {
            helper(node.right, s + node.val + "->");
        }
    }
}