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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return helper(nums, 0, nums.length - 1);
    }
    
    public TreeNode helper(int[] nums, int begin, int end) {
        if (begin > end) return null;
        int mid = (end - begin) / 2 + begin;    
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode left = helper(nums, begin, mid - 1);
        TreeNode right = helper(nums, mid + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }
}
