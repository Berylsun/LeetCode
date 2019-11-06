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
    
    public void helper(List<String> res, String s, TreeNode root) {
        if (root.right == null && root.left == null) {
            s += root.val;
            res.add(s);
            return;
        }
        if (root.left != null) helper(res, s + root.val + "->", root.left);
        if (root.right != null) helper(res, s + root.val + "->", root.right);
    }
}
