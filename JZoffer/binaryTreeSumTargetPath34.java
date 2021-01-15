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
    /**
     * O(n)
     * O(n)
     */
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        helper(root, sum, new ArrayList<>(), 0);
        return res;
    }

    public void helper(TreeNode root, int sum, List<Integer> list, int k) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left == null && root.right == null && sum == k + root.val) {
            res.add(new ArrayList<>(list));
        }
        helper(root.right, sum, list, root.val + k);
        helper(root.left, sum, list, root.val + k);
        list.remove(list.size() - 1);
    }
}