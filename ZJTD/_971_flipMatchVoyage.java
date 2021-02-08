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
    int i = 0;
    List<Integer> res;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        res = new ArrayList<>();
        boolean ans = helper(root, voyage);
        if (!ans) {
            res = new ArrayList<>();
            res.add(-1);
        }
        return res;
    }

    public boolean helper(TreeNode root, int[] voyage) {
        if (root == null) return true;
        if (root.val != voyage[i++]) return false;
        if (root.left != null && root.left.val != voyage[i]) {
            res.add(root.val);
            return helper(root.right, voyage) && helper(root.left, voyage);
        }
        return helper(root.left, voyage) && helper(root.right, voyage);
    }


    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        int idx = 0;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.val != voyage[idx++]) {
                res.clear();
                res.add(-1);
                break;
            }
            if (node.left != null && node.left.val != voyage[idx]) {
                res.add(node.val);
                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;
            }
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return res;
    }
}