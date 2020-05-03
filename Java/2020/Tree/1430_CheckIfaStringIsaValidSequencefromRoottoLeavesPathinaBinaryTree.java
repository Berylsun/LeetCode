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
     * @param root
     * @param arr
     * @return
     */
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return helper(root, arr, 0);
    }

    public boolean helper(TreeNode root, int[] arr, int idx) {
        if (root == null || root.val != arr[idx]) return false;
        if (idx == arr.length - 1) {
            if (root.right == null && root.left == null) {
                return true;
            }
            return false;
        }
        if (helper(root.left, arr, idx + 1) || helper(root.right, arr, idx + 1)) {
            return true;
        }
        return false;
    }
}