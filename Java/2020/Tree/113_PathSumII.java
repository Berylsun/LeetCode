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
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        if (root == null) return res;
        helper(root, sum, new ArrayList<>());
        return res;
    }

    public void helper(TreeNode node, int sum, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        if (node.left == null && node.right == null) {
            if (sum == node.val) {
                res.add(new ArrayList<>(list));
            }
        }

        helper(node.left, sum - node.val, list);
        helper(node.right, sum - node.val, list);
        list.remove(list.size() - 1);
    }
}