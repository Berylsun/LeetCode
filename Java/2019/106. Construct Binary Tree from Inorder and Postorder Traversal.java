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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(0, inorder.length - 1, postorder.length - 1, inorder, postorder);
    }
    
    public TreeNode helper(int inStart, int inEnd, int postEnd, int[] inorder, int[] postorder) {
        if (inEnd < inStart || postEnd < 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (root.val == inorder[i]) {
                inIndex = i;
            }
        }
        root.right = helper(inIndex + 1, inEnd, postEnd - 1, inorder, postorder);
        root.left = helper(inStart, inIndex - 1, postEnd - (inEnd - inIndex) - 1, inorder, postorder);
        return root;
    }
}



    int pInorder;
    int pPostorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pInorder = inorder.length - 1;
        pPostorder = postorder.length - 1;
        return helper(inorder, postorder, null);
    }

    public TreeNode helper(int[] inorder, int[] postorder, TreeNode end) {
        if (pPostorder < 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pPostorder--]);
        if (inorder[pInorder] != root.val) {
            root.right = helper(inorder, postorder, root);
        }
        pInorder--;
        if ((end == null) || (inorder[pInorder] != end.val)) {
            root.left = helper(inorder, postorder, end);
        }
        return root;
    }
