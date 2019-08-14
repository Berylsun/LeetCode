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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, "", root);
        return res;
    }
    
    public void helper(List<String> res, String s, TreeNode node) {
        if (node.left == null && node.right == null) {
            s += node.val;
            res.add(s);
            return;
        }
        if (node.left != null) {
            helper(res, s + node.val + "->", node.left);
        }
        if (node.right != null) {
            helper(res, s + node.val + "->", node.right);
        }
    }
}
