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
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode helper(int preS, int inS, int inE, int[] preorder, int[] inorder) {
        if (preS >= preorder.length || inS > inE) return null;
        TreeNode root = new TreeNode(preorder[preS]);
        int inidx = 0;
        for (int i = inS; i <= inE; i++) {
            if (inorder[i] == preorder[preS]) {
                inidx = i;
            }
        }
        root.left = helper(preS + 1, inS, inidx - 1, preorder, inorder);
        root.right = helper(preS + 1 + inidx - inS, inidx + 1, inE, preorder, inorder);
        return root;
    }
}